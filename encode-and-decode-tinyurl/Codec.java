public class Codec {
  private Map<String, String> urlMapper = new HashMap<>();
  private Random rand = new Random();
  private byte[] stringArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".getBytes();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String shortened = getShortUrl(longUrl);
    urlMapper.put(shortened, longUrl);
    return shortened;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return urlMapper.get(shortUrl);
  }
}

