class TextEditor {
StringBuilder sb;
    int idx;
    public TextEditor() {
        sb = new StringBuilder();
        idx = 0;
    }
    
    public void addText(String text) {
        sb.insert(idx, text);
        idx += text.length();
    }
    
    public int deleteText(int k) {
       
        sb.delete(Math.max(0, idx - k), idx);
        int len = idx - Math.max(0, idx - k);
        idx = Math.max(0, idx - k);
        return len;
    }
    
    public String cursorLeft(int k) {
        idx = Math.max(0, idx - k);
        return sb.substring(Math.max(0, idx - 10), idx);
    }
    
    public String cursorRight(int k) {
     
        idx = Math.min(sb.length(), idx + k);
        
        return sb.substring(Math.max(0, idx - 10), idx);
    }
}
​
/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
