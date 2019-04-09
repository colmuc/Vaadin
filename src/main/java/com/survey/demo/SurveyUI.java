package com.survey.demo;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class SurveyUI extends UI{
//I followed the examples of an online tutorial
        private VerticalLayout root;
        @Autowired
        SurveyLayout surveyLayout;
        @Override
        protected void init(VaadinRequest request){
                setupLayout();
                addHeader();
                addQuestion();
                addForm();
                addSurvey();


        }





        private void setupLayout(){
                root=new VerticalLayout();
                setContent(root);
        }

        private void addHeader(){
                root.addComponent(new Label("Survey"));
        }

        private void addQuestion(){
                root.addComponent(new Label("What is your favorite dog?"));
        }


        private void addForm(){
               HorizontalLayout formLayout= new HorizontalLayout();
               formLayout.setWidth("50%");
               TextField answer = new TextField();
               Label label = new Label("");
               Button submit = new Button("Submit");
               submit.addClickListener(e->{
                   label.setValue("Your favorite dog is "+answer.getValue());
               });
               submit.addStyleName(ValoTheme.BUTTON_PRIMARY);
               formLayout.addComponentsAndExpand(answer);
               formLayout.addComponent(submit);
               root.addComponents(formLayout,label);
        }

        private void addSurvey(){
            surveyLayout.setWidth("50%");
                root.addComponent(surveyLayout);
        }
}

