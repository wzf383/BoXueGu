package cn.edu.gdmec.android.boxuegu.bean;

/**
 * Created by 38322 on 2018/1/26.
 */

public class ExercisesBean {
    public int id;//每章习题ID
    public String title;//每章习题标题
    public  String content;//每章习题的数目
    public  int background;//每章习题前边的序号背景
    public  int subjectId;//每道习题的id
    public  String subject;//每道习题的题干
    public  String a;//每道题的A选项
    public  String b;//每道题B
    public  String c;//每道题C
    public  String d;//每道题D
    public  int answer;//每道题的正确答案
    /*select为0表示所选项是对的，1表示选中的A选项是错的，2表示选中的B选项是错的，3
    * 表示选中的C选项是错的，4表示选中的D选项是错的
    * */
    public  int select;
}
