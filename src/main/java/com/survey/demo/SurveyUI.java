package com.survey.demo;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class SurveyUI extends UI{

        private VerticalLayout root;
        @Autowired
        SurveyLayout surveyLayout;
        @Override
        protected void init(VaadinRequest request){
                setupLayout();
                addHeader();
                addQuestion();
                addForm();
                addTodoList();
                addDeleteButton();

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
        private void addDeleteButton(){
                root.addComponent(new Button("Delete"));
        }

        private void addForm(){
               HorizontalLayout formLayout= new HorizontalLayout();
               TextField answer = new TextField();
               Button submit = new Button("Submit");
               formLayout.addComponents(answer, submit);
               root.addComponent(formLayout);
        }

        private void addTodoList(){
                root.addComponent(surveyLayout);
        }
}

