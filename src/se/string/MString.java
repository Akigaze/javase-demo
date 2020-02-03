package se.string;

public class MString {
  private final char[] value = {};

  public boolean endsWith(MString suffix){
    return this.endsWith(suffix, 0);
  }

  private boolean endsWith(MString suffix, int offset) {
    int len = this.value.length;
    int from = offset;
    int to = 0;
    int suffixLen = suffix.value.length;

    if ((offset < 0) || (offset > len - suffixLen)){
      return false;
    }
//    while (){
//      if(this.value[from++] != suffix.value[to++]){
//        return false;
//      }
//    }
    return true;

  }

}
