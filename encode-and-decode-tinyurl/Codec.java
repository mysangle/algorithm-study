public class Codec {
    private Map<String, String> urlMapper = new HashMap<>();
    private Random rand = new Random();
    private byte[] stringArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".getBytes();

    private String getShortUrl() {
      byte[] s = new byte[6];
      for (int i = 0; i < 6; i++) {
        int n = rand.nextInt(62);
        s[i] = stringArray[n];
      }
      return "http://tinyurl.com/" + new String(s);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortened = null;
        int count = 0;
        while (count < 10) {
            shortened = getShortUrl();
            if (urlMapper.get(shortened) == null) {
                urlMapper.put(shortened, longUrl);
                break;
            }
            count++;
        }
        return shortened;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMapper.get(shortUrl);
    }
}

