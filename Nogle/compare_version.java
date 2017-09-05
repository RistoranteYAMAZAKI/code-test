public class compare_version {
    public int compareVersion(String version1, String version2) {
        float f1 = Float.valueOf(version1);
		float f2 = Float.valueOf(version2);
		int condition = Float.compare(f1, f2);
		
		if(condition > 0) {
			return 1;
		}
		else if(condition < 0) {
			return -1;
		}
		else
			return 0;
    }
	
	public static void main(String[] args) {
		compare_version c = new compare_version();
		String v1 = "13.37";
		String v2 = "13.372222"; 
		System.out.println(c.compareVersion(v1,v2));
	}
}