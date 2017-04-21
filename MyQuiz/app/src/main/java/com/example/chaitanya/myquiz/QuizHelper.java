package com.example.chaitanya.myquiz;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =2;
    // Database Name
    private static final String DATABASE_NAME = "bcd";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_ID2 = "id"; // option c
    public static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    public static final String KEY_OPTA = "opta"; // option a
    public static final String KEY_OPTB = "optb"; // option b
    public static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_ID2 + " INTEGER)";
        db.execSQL(sql);
        addQuestion();
        // db.close();

    }

    private void addQuestion() {
        Question q1 = new Question("Who is the president of india ?", "narender modi", "hamid ansari", "pranab mukherji", "pranab mukherji",3);
        this.addQuestion(q1);
        Question q2 = new Question(" Name of the first university of India  ?", "Nalanda University", "Takshshila University", "BHU", "Nalanda University",2);
        this.addQuestion(q2);
        Question q3 = new Question("Which college is awarded as Outstanding Engineering Institute North Award?", "Thapar University", "G.N.D.E.C", "S.L.I.E.T", "G.N.D.E.C",5);
        this.addQuestion(q3);
        Question q4 = new Question("Name of the first Aircraft Carrier Indian Ship ?", "Samudragupt", "I.N.S. Vikrant", "I.N.S Virat", "I.N.S. Vikrant",2);
        this.addQuestion(q4);
        Question q5 = new Question("In which town of Punjab the largest grain market of Asia is Available?", "Bathinda", "Khanna", "Ludhiana", "Khanna",5);
        this.addQuestion(q5);
        Question q6 = new Question("Which is the highest dam in India?", "Bhakhra Dam", "Hirakud Dam", "Tehri Dam", "Tehri Dam",5);
        this.addQuestion(q6);
        Question q7 = new Question("Which Indian state is having longest coastline ?", "Rajasthan", "Gujrat", "Punjab", "Gujrat",5);
        this.addQuestion(q7);
        Question q8 = new Question("Name of the first Country to print books ?", "China", "India", "USA", "China",2);
        this.addQuestion(q8);
        Question q9 = new Question("Study of the Universe is known as?", "Sociology", "Cosmology", "Petology", "Cosmology",4);
        this.addQuestion(q9);
        Question q10 = new Question("Big Bang theory explains ?", "Origin of Universe.", "Origin of Sun", "Laws of physics.", "Origin of Universe.",4);
        this.addQuestion(q10);
        Question q11 = new Question("Which Planet is dwarf planet?", "Mercury", "Pluto",   "Venus", "Pluto",4);
        this.addQuestion(q11);
        Question q12 = new Question(" In South Asia,the country with the largest percentage of aged population is ?", "India", "Sri Lanka", "Nepal", "Sri Lanka",5);
        this.addQuestion(q12);
        Question q13 = new Question("Which is the Largest lake of the world ?", "Caspian Sea ", "Dead Sea", "Arabian sea", "Caspian Sea ",5);
        this.addQuestion(q13);
        Question q14 = new Question("Which of following industry is famous of Jalandhar city?", "Cycle Parts Industry", "Electronics", "Sports Goods Manufacturing", "Sports Goods Manufacturing",1);
        this.addQuestion(q14);
        Question q15 = new Question("Capital of Punjab is:", "Ludhiana", "Amritsar", "Chandigarh", "Chandigarh",3);
        this.addQuestion(q15);
        Question q16 = new Question("How many  Seats of lok sabha are filled by the candidate of Punjab ?", "12", "17", "13", "13",3);
        this.addQuestion(q16);
        Question q17 = new Question("In Malwa and Doaba regions ____ river separates?", " Beas", "Jehlam", "Satluj", "Satluj",5);
        this.addQuestion(q17);
        Question q18 = new Question("Which one of the following city of Punjab State was known as Virat Ki Nagri?", "Amritsar", "Dasuha", "Ludhiana", "Dasuha",2);
        this.addQuestion(q18);
        Question q19 = new Question("Sachin Tendulkar scored his 100th international century against whichâ€™ country ?", "Bangladesh", "Australia", "West Indies", "Bangladesh",1);
        this.addQuestion(q19);
        Question q20 = new Question("What is the minimum permissible age for employment in any factory or mine?", "16", "13", "14", "14",3);
        this.addQuestion(q20);
        Question q21 = new Question("Where is India's First nuclear centre ?", "Rampur", "Mirapur", "Tarapur", "Tarapur",4);
        this.addQuestion(q21);
        Question q22 = new Question("Who was known as Iron man of India?","Govind Ballabh Pant","Sardar Vallabhbhai Patel","Subhash Chandra Bose","Sardar Vallabhbhai Patel",2);
        this.addQuestion(q22);
        Question q23 = new Question("The Indian to beat the computers in mathematical wizardry is:","Ramananujam","Shakuntla Devi","Raja Ramanna","Shakuntla Devi",2);
        this.addQuestion(q23);
        Question q24 = new Question("Professor Amartya Sen is famous in which of the fields?","Geology","Economics","Electronics","Economics",4);
        this.addQuestion(q24);
        Question q25 = new Question("Hitler party which came into power in 1933 is known as:","Nazi","Democratic","Labour","Nazi",3);
        this.addQuestion(q25);
        Question q26 = new Question("Tipu sultan was the ruler of:","Mysore","jhansi","Delhi","Mysore",2);
        this.addQuestion(q26);
        Question q27 = new Question("Modern Indo-Aryan languages are based on an ancient language called:","English","Hindi","Sanskrit","Sanskrit",2);
        this.addQuestion(q27);
        Question q28 = new Question("Ludhiana is situated on ____ river:","Satluj","Yamuna","Beas","Satluj",5);
        this.addQuestion(q28);
        Question q29 = new Question("Kiran Bedi is:","first woman IAS officer","first woman IPS officer","First women judge","first woman IPS officer",5);
        this.addQuestion(q29);
        Question q30 = new Question("Number of commands of Air Force are","8","7","6","7",5);
        this.addQuestion(q30);
        Question q31 = new Question("Of the following foods, which one is the best source of protein?","Milk","Butter","Fish","Fish",4);
        this.addQuestion(q31);
        Question q32= new Question("Commonwealth Games are held at intervals of","3","4","5","4",1);
        this.addQuestion(q32);
        Question q33= new Question("Lal Bahadur Shastri is also known as","Man of Peace","Punjab Kesri","Guruji","Man of Peace",2);
        this.addQuestion(q33);
        Question q34= new Question("Light Year is related to","Power","Speed","Distance","Distance",4);
        this.addQuestion(q34);
        Question q35= new Question("Nalanda is located at","U.P","Bihar","Haryana","Bihar",5);
        this.addQuestion(q35);
        Question q36=new Question("The members of Lok Sabha hold office for a term of:","3 years","4 years","5 years","5 years",3);
        this.addQuestion(q36);
        Question q37=new Question("The minimum age to qualify for election to the Lok Sabha is:","23 years","24 years","25 years","25 years",3);
        this.addQuestion(q37);
        Question q38=new Question("The minimum age of the voter in India is:","17","18","19","18",3);
        this.addQuestion(q38);
        Question q39=new Question("The 'Dronacharya Award' is given to...?","Sportsman","Umpires","Coaches","Coaches",1);
        this.addQuestion(q39);
        Question q40=new Question("How many gold medals have been won by India in the Olympics so far?","8","9","10","9",1);
        this.addQuestion(q40);
        Question q41= new Question("Who is the present RBI Governor ?","Urjit Patel","Raghu Ram Rajan","R.Reddy","Urjit Patel",5);
        this.addQuestion(q41);
        Question q42= new Question("How many coastal states are in India ?","7","8","9","9",5);
        this.addQuestion(q42);
        Question q43=new Question("The country which lost the largest number of people in the 2nd world war ?","Russia","Japan","U.S.A","Japan",2);
        this.addQuestion(q43);
        Question q44=new Question("Which is the largest fresh water lake in India ?","Wular Lake","Dal Lake","R.C.F Lake","Wular Lake",5);
        this.addQuestion(q44);
        Question q45=new Question("What is the full form of https ?","Hyperactive Transfer Protocol"," Hypertext Transfer Protocol Secure","hyper Transfer Protocol Server"," Hypertext Transfer Protocol Secure",4);
        this.addQuestion(q45);
        Question q46=new Question("Which is the coldest planet in the solar system?","Mercury","Saturn","Neptune","Neptune",4);
        this.addQuestion(q46);
        Question q47=new Question("Which country is known as land of white elephants?","Thailand","Singapore","China","Thailand",5);
        this.addQuestion(q47);
        Question q48=new Question("The Gate way of India is ?","Mumbai","Delhi","Chennai","Mumbai",5);
        this.addQuestion(q48);
        Question q49=new Question("The first chairman of the Atomic Energy Commission was ?","Dr.C.V.Raman","Dr.H.J.Bhabha","Dr.Vickram Sarabhai","Dr.H.J.Bhabha",4);
        this.addQuestion(q49);
        Question q50=new Question("Which is considered as the biggest port of India ?","Mumbai","Kolkata","Chennai","Mumbai",5);
        this.addQuestion(q50);
        Question q51=new Question("The famous Ganga Sagar Mela, an annual fair is held in which state of India?","U.P","Haryana","West Bengal","West Bengal",5);
        this.addQuestion(q51);
        Question q52=new Question("Country that was called as Land of Rising Sun ?","Japan","Russia","Korea","Japan",5);
        this.addQuestion(q52);
        Question q53=new Question("Pink city in India is ?","Jaipur","Meerut","Shimla","Jaipur",5);
        this.addQuestion(q53);
        Question q54=new Question("One People, One State, One leader was the policy of ?","Stalin","Hitler","Lenin","Hitler",2);
        this.addQuestion(q54);
        Question q55=new Question("Who among the following appoints the Prime Minister of India?","Rajya Sabha","Lok Sabha","President of India","President of India",3);
        this.addQuestion(q55);
        Question q56=new Question("The most important river of Orissa is ?","Godavri","Mahanadi","Brahmputra","Mahanadi",5);
        this.addQuestion(q56);
        Question q57=new Question("2010 Commonwealth Games held in ?","India","Germany","Canada","India",1);
        this.addQuestion(q57);
        Question q58=new Question("The term Googly is associated with ?","Cricket","Football","Chess","Cricket",1);
        this.addQuestion(q58);
        Question q59=new Question("The most populous city in the world is:","Tokyo","U.P","Beijin","Tokyo",5);
        this.addQuestion(q59);
        Question q60=new Question("Indian standard time is the local time of:","Chennai","Allahbad","Mumbai","Allahbad",4);
        this.addQuestion(q60);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        if (newV > oldV) {
            db.execSQL("ALTER TABLE " + TABLE_QUEST + " ADD COLUMN " + KEY_ID2 + " INTEGER ");
        }
    }

    protected void insertIntoDB(){
         dbase = this.getWritableDatabase();
        String id = Profile.edit.getText().toString().trim();
        String que = Profile.edit1.getText().toString().trim();
        String opa = Profile.edit2.getText().toString().trim();
        String opb = Profile.edit3.getText().toString().trim();
        String opc = Profile.edit4.getText().toString().trim();
        String ans = Profile.edit5.getText().toString().trim();
        String query = "INSERT INTO "+TABLE_QUEST+" ("+KEY_ID2+","+KEY_ANSWER+","+KEY_QUES+","+KEY_OPTA+","+KEY_OPTB+","+KEY_OPTC+") VALUES('"+id+"', '"+ans+"','"+que+"','"+opa+"','"+opb+"','"+opc+"');";
        dbase.execSQL(query);
    }

    protected void deleteDB(){
        dbase = this.getWritableDatabase();
        dbase.execSQL("DELETE FROM " +TABLE_QUEST+ " WHERE " + KEY_ID + " = '"+admin.itemPosition+"'");
    }


    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_ID2,quest.getID());
        Log.i("here4",quest.getID()+"");
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID2 + " = '"+catogaries.ab+"'";
        // + KEY_ID2 + " = 1"

        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        Log.i("here1",cursor.getCount()+"");

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public List<Question> getAllQuestions2() {
        List<Question> quesList2 = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        // + KEY_ID2 + " = 1"

        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        Log.i("here1",cursor.getCount()+"");

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList2.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList2;
    }


}
