package double_ranch.taskholder;

/**
 * Created by 7408588 on 6/22/2017.
 */

public class TaskLayout {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public TaskLayout(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

}
