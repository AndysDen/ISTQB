package com.istqb.anandsoni.multichoicequest;



import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by anandsoni on 2016-03-20.
 */
public class LoadQuestionData {

    private static XmlPullParserFactory xmlFactoryObject = null;
    private static XmlPullParser myparser =null;
    private static Map<String,List<Questions>> questionsMap = new HashMap<String,List<Questions>>();

    public static Map<String,List<Questions>>  loadData(InputStream inputStream) throws XmlPullParserException, IOException {

        //InputStream inputStream=readInputStream();
        xmlFactoryObject= XmlPullParserFactory.newInstance();
        myparser=  xmlFactoryObject.newPullParser();
        myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        myparser.setInput(inputStream,null);
        myparser.nextTag();
        readFeed(myparser);

        Set<String> keySet=questionsMap.keySet();
        for(String set:keySet){
            System.out.println(set);
            for(Questions question:questionsMap.get(set)){
                System.out.println(question.getQuestion());
            }
        }

        System.out.println(questionsMap);
        return questionsMap;
    }

    private static Map<String,List<Questions>> readFeed(XmlPullParser myparser) throws XmlPullParserException, IOException {
        int event = myparser.getEventType();
        while(event !=XmlPullParser.END_DOCUMENT){
            String name=myparser.getName();
            switch (event) {
                case XmlPullParser.START_TAG:
                    String category=null;
                    if(name.equals("category")){
                        category=myparser.getAttributeValue(null, "name");
                        //category=myparser.getAttributeValue(null, "name");
                        System.out.println(category);
                        List<Questions> listOfQuestions=collectTheQuestionsForCategory(myparser);
                        questionsMap.put(category, listOfQuestions);
                    }

                    break;
                case XmlPullParser.END_TAG:
                    break;
                default:
                    break;
            }
            event = myparser.next();
        }
        return questionsMap;

    }

    private static List<Questions> collectTheQuestionsForCategory(XmlPullParser myparser) throws XmlPullParserException, IOException {
        int event = myparser.getEventType();
        List<Questions> listOfQuestions= new ArrayList<Questions>();

        while(event !=XmlPullParser.END_DOCUMENT){
            String name=myparser.getName();
            switch (event) {

                case XmlPullParser.START_TAG:
                    Questions question =null;

                    if(name.equals("question")){
                        question=collectQuestion(myparser);
                        listOfQuestions.add(question);
                    }

                    break;
                case XmlPullParser.END_TAG:
                    if(name.equals("category")){
                        System.out.println("End of Category");
                        return listOfQuestions;
                    }



                    break;
                default:
                    break;
            }

            event = myparser.next();

        }
        return listOfQuestions;

    }

    private static Questions collectQuestion(XmlPullParser myparser) throws XmlPullParserException, IOException {
        int event = myparser.getEventType();
        Questions question= new Questions();
        while(event !=XmlPullParser.END_DOCUMENT){
            String name= myparser.getName();
            switch(event){
                case XmlPullParser.START_TAG:
                    if(name.equals("q")){
                        String ques=myparser.nextText();
                        System.out.println(ques);
                        question.setQuestion(ques);
                    }
                    else if(name.equals("option1") ||name.equals("option2")|| name.equals("option3") || name.equals("option4") ){
                        String option=myparser.nextText();
                        System.out.println(option);
                        question.addOption(option);
                    } else if((name.equals("correctAnswer"))){
                        String correctAnswer=myparser.nextText();
                        System.out.println(correctAnswer);
                        question.setCorrectAnswer(correctAnswer);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if(name.equals("question")){
                        System.out.println("Question has ended");
                        return question;
                    }
                    break;
            }
            event = myparser.next();
        }

        return null;
    }

    private static InputStream readInputStream() throws FileNotFoundException {

        File file = new File("questions.xml");
        System.out.println(file.canExecute());
        InputStream inputStream= new FileInputStream("questions.xml");

        return inputStream;
    }


}
