package dongting.bwei.com.weektwob;

/**
 * 作者:${董婷}
 * 日期:2017/6/18
 * 描述:
 */

public class Bean {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bean(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
