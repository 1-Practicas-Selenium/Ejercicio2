package test;



public class SearchTvShow extends BaseTest {
	
	
	
	public static void main(String[] args)  {
		
		setUp("Chrome", "http://localhost:3000/shows");
		searchtvShow("Batman");
		clickLink();
		page_back();
		change_color();
		buttonback();
		closeBrowser();

	}







}
