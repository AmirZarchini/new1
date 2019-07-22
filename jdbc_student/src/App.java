import com.daoimpl.PersonDaoImpl;
import com.entities.Person;
import com.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int input1;
        int number;
        Scanner input = new Scanner ( System.in );

        System.out.println ( "welcom to my system" + "\n" + " what activity do you want to do?" + "1-creat 2-read 3-delete 4-update" + "\n" );
        input1 = input.nextInt ( );

        switch (input1) {

            case 1:

                System.out.println ( "Please enter the number of entries:" );
                number = input.nextInt ( );
                for (int i = 0; i < number; i++) {

                    PersonDaoImpl pdi = new PersonDaoImpl ( );
                    String x1, x2, x3, x4, x5;
                    System.out.println("first_name:"+"\n");
                    x1 = input.next ( );
                    System.out.println("last_name:"+"\n");
                    x2 = input.next ( );
                    System.out.println("age:"+"\n");
                    x3 = input.next ( );
                    System.out.println("base_educational:"+"\n");
                    x4 = input.next ( );
                    System.out.println("ave_base:"+"\n");
                    x5 = input.next ( );
                    Person person = new Person ( x1 , x2 , x3 , x4 , x5 );
                    pdi.insert ( person );

                }

                break;

            case 2:
                PersonDaoImpl pdi = new PersonDaoImpl ( );
                System.out.println ( "If you want someone\n" +
                        "Enter the number 1, then enter the ID, otherwise, enter the number 2" );
                number = input.nextInt ( );
                if (number == 1) {

                    System.out.println ( "please enter the ID: " );
                    int x = input.nextInt ( );

                    Person person = pdi.selectById ( x );
                    System.out.println ( person.getId ( ) + " , " + person.getFirstName ( ) + " , " + person.getLastName ( ) + " , " + person.getAge ( ) + " , " + person.getBase ( ) + " , " + person.getAve_base ( ) );

                } else if (number == 2) {

                    List<Person> persons = pdi.selectAll ();

                     for(Person person : persons) {

                     System.out.println ( person.getId () + " , " + person.getFirstName () + " , " + person.getLastName () + " , " + person.getAge () + " , " + person.getBase () + " , " + person.getAve_base () );

                     }



                }

                break;

            case 3:
                pdi = new PersonDaoImpl ( );

                System.out.println ( "plese enter the your ID for delete:" + "\n" );
                number = input.nextInt ();

                pdi.delete ( number );

                List<Person> persons = pdi.selectAll ();

                 for(Person person : persons) {

                     System.out.println ( person.getId () + " , " + person.getFirstName () + " , " + person.getLastName () + " , " + person.getAge () + " , " + person.getBase () + " , " + person.getAve_base () );

                 }

                 break;

            case 4:
                pdi = new PersonDaoImpl ( );


                persons = pdi.selectAll ( );

                for(Person person : persons) {

                System.out.println ( person.getId () + " , " + person.getFirstName () + " , " + person.getLastName () + " , " + person.getAge () + " , " + person.getBase () + " , " + person.getAve_base () );

                }
                System.out.println (  "\n\n"+"plese enter the your ID for update:" + "\n" );
                number = input.nextInt ();
                System.out.println ( "please enter the changes:" + "\n" );
                String x1, x2, x3, x4, x5;
                x1 = input.next ( );
                x2 = input.next ( );
                x3 = input.next ( );
                x4 = input.next ( );
                x5 = input.next ( );
                Person person = new Person ( x1 , x2 , x3 , x4 , x5 );
                pdi.update ( person , number );

                break;

                default:


        }


        // pdi.createPersonTable ();



    }
}







