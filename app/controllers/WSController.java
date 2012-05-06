package controllers;

import org.w3c.dom.Document;

import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.xml.TheWSwsdl;
import views.xml.helloResponse;


public class WSController extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	@BodyParser.Of(play.mvc.BodyParser.Xml.class)
	public static Result wsdl(String wsdlParam) {
		return ok(TheWSwsdl.render());
	}

	@BodyParser.Of(play.mvc.BodyParser.Xml.class)
	public static Result router() {
		try {
			Document dom = request().body().asXml();
			Logger.info(dom.toString());
			return ok(helloResponse.render("Salut"));
		} catch (Exception e) {
			Logger.error(e.toString(), e);
			return internalServerError(e.toString());
		}
	}
}