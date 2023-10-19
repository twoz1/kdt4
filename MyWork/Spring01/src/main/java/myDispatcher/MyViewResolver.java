package myDispatcher;

public class MyViewResolver {
	
	private String prefix;
	private String suffix;
	
	public void setPrifix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getViewName(String viewName) {
		viewName = prefix + viewName + suffix;
		System.out.println("viewName => " + viewName);
		return viewName;
	}
	
}
