package com.example.murtuza.feeder.RSS;

/**
 * Created by Murtuza on 03-01-2017.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.murtuza.feeder.Article;
import com.example.murtuza.feeder.UI.MyAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;


public class RSSParser extends AsyncTask<Void, Void, Boolean> {
    Context c;
    InputStream is;//
    RecyclerView rv;
    ProgressDialog pd;
    ArrayList<Article> articles = new ArrayList<>();
    boolean[] rs;

    public RSSParser(Context c, InputStream is, RecyclerView rv) {
        this.c = c;
        this.is = is;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            return this.parseRSS();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        pd.dismiss();
        if (isParsed) {
            //BIND

            rv.setAdapter(new MyAdapter(c, articles));
        } else {
            Toast.makeText(c, "Unable To Parse", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseRSS() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, XmlPullParserException {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(is, null);
            int event = parser.getEventType();
            String tagValue = null;
            Boolean isSiteMeta = true;
            articles.clear();
            Article article = new Article();
            do {
                String tagName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")) {
                            article = new Article();
                            isSiteMeta = false;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        tagValue = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (!isSiteMeta) {
                            if (tagName.equalsIgnoreCase("title")) {
                                article.setTitle(tagValue);
                            } else if (tagName.equalsIgnoreCase("description")) {
                                String desc = tagValue;
                                article.setDescription(desc);

                                try {
                                    Document document = Jsoup.parse(desc);
                                    Elements imgs = document.select("img");

                                    for (Element img : imgs) {
                                        if (img.hasAttr("src")) {
                                            article.setImageUrl(img.attr("src"));
                                        }
                                    }


                                    Element des = document.select("span").first();


                                    //for (Element de : des) {
                                    //  {
                                    article.setDescription(des.text().toString());
                                    //}
                                    //}
                                    // for(int k= 1;k<des.size();k++)
                                    //{
                                    //  String spancontent =des.get(k).text();
                                    //Log.i("..........",spancontent);
                                    //}


                                } catch (Exception e) {

                                }
                            }  else if (tagName.equalsIgnoreCase("media:content")) {
                            String url = parser.getAttributeValue(null, "url");
                             article.setImageUrl(url);


                            }
                            else if (tagName.equalsIgnoreCase("media:thumbnail")) {
                                String url = parser.getAttributeValue(null, "url");
                                article.setImageUrl(url);


                            }
                            else if (tagName.equalsIgnoreCase("content:encoded")) {
                               String ce=tagValue;
                                Document document = Jsoup.parse(ce);
                               Elements imgs = document.select("img");

                                for (Element img : imgs) {
                                  if (img.hasAttr("src")) {
                                       article.setImageUrl(img.attr("src"));
                                    }
                                }


                            }
                        else if (tagName.equalsIgnoreCase("thumbnail")) {
                                //String url = parser.getAttributeValue(null, "url");
                                article.setImageUrl(tagValue);


                            } else if (tagName.equalsIgnoreCase("link")) {
                                article.setLink(tagValue);

                            }


                        } else if (tagName.equalsIgnoreCase("pubDate")) {
                            article.setDate(tagValue);
                        }

                        if (tagName.equalsIgnoreCase("item")) {
                            articles.add(article);
                            isSiteMeta = true;
                        }
                        break;
                }

                event = parser.next();

            }
            while (event != XmlPullParser.END_DOCUMENT);
            return true;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (ParserConfigurationException e) {
        //e.printStackTrace();
        //} catch (SAXException e) {
        // e.printStackTrace();
        //}
        return false;
    }
}

