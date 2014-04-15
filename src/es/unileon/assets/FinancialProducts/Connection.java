package es.unileon.assets.FinancialProducts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.jndi.toolkit.url.Uri;

public class Connection {
	String urlDatosMacro="http://www.datosmacro.com/hipotecas/";
	public String title;
	private Elements query;
	double rate;
	
	public void connection(KindOfRate rate) throws IOException{
		
		Document doc = Jsoup.connect(urlDatosMacro+rate.name).get();
		title = doc.title();
		this.query=doc.select("td[class=numero]");
	//	System.out.println(query);
		Element interest=this.query.first();
		char [] charsInterest=interest.text().toCharArray();
		charsInterest[1]='.';
		String num=String.copyValueOf(charsInterest,0,charsInterest.length-1 );
		this.rate=Double.valueOf(num);
		
//		System.out.println(irs);
	}
	
	
	public String getTitle() {
		return title;
	}
	public Elements getQuery() {
		return query;
	}


	public double getRate() {
		return rate;
	}
	
	
	
	

}
