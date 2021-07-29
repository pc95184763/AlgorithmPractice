package OOD4FileSystem;

import OOD4FileSystem.Directory;
import OOD4FileSystem.Entry;

public class File extends Entry {
  private String content; // byte[] is better
  private int size ;

  @Override
  public int size() {

    return size;
  }

  public File(String n, Directory p, int sz) {
    super(n, p) ;
    size = sz ;
  }

  public String getContent() {
    return content ;
  }

  public void setContent (String c) {
    content = c ;
  }



}
