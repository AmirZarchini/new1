package com.daoimpl;

import com.dao.PersonDao;
import com.entities.Person;
import com.util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void createPersonTable() {

        Connection connection = null;
        Statement statement = null;

        try {

            connection = ConnectionConfiguration.getConnction ();
            statement = connection.createStatement();
            statement.execute ( "CREATE TABLE IF NOT EXISTS person(id int primary key unique auto_increment," +
                    "first_name varchar (45) , last_name varchar (45) , age varchar (45) , base varchar (45) , ave_base varchar (45)) " );

        }catch (Exception e){

            e.printStackTrace ();
        }finally {

            if (statement != null){

                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

            if (connection != null){

                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

        }
    }

    @Override
    public void insert(Person person) {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfiguration.getConnction ();

            preparedStatement = connection.prepareStatement ( "INSERT INTO person( first_name , last_name , age , base , ave_base) " +
                    "VALUES ( ? , ? , ? , ? , ? )" );
            preparedStatement.setString ( 1 , person.getFirstName () );
            preparedStatement.setString ( 2 , person.getLastName () );
            preparedStatement.setString ( 3 , person.getAge () );
            preparedStatement.setString ( 4 , person.getBase () );
            preparedStatement.setString ( 5 , person.getAve_base () );
            System.out.println (preparedStatement);
            preparedStatement.executeUpdate ();



        }catch (Exception e){

            e.printStackTrace ();

        }finally {

            if (preparedStatement != null){

                try {
                    preparedStatement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
             if (connection != null){

                 try {
                     connection.close ();
                 } catch (SQLException e) {
                     e.printStackTrace ( );
                 }
             }
        }
    }

    @Override
    public Person selectById(int id) {

        Person person = new Person (  );
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionConfiguration.getConnction ();
            preparedStatement = connection.prepareStatement ( "SELECT * FROM person WHERE id =?" );
            preparedStatement.setInt ( 1 , id );
            resultSet = preparedStatement.executeQuery ();

            while (resultSet.next ()){

                person.setId ( resultSet.getInt ( "id" ) );
                person.setFirstName ( resultSet.getString ( "first_name" ) );
                person.setLastName ( resultSet.getString ( "last_name" ) );
                person.setAge ( resultSet.getString ( "age" ) );
                person.setBase ( resultSet.getString ( "base" ) );
                person.setAve_base ( resultSet.getString ( "ave_base" ) );
            }

        }
        catch ( Exception e){

            e.printStackTrace ();
        }
        finally {

            if (resultSet != null){

                try {
                    resultSet.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if (preparedStatement != null){

                try {
                    preparedStatement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if (connection != null){

                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

        }




        return person;
    }

    @Override
    public List<Person> selectAll() {

        List<Person> persons = new ArrayList<Person> (  );
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionConfiguration.getConnction ();
            statement = connection.createStatement ();
            resultSet = statement.executeQuery ( "SELECT * FROM person" );

            while (resultSet.next ()){

                Person person = new Person (  );
                person.setFirstName ( resultSet.getString ( "first_name" ) );
                person.setLastName ( resultSet.getString ( "last_name" ) );
                person.setAge ( resultSet.getString ( "age" ) );
                person.setBase ( resultSet.getString ( "base" ) );
                person.setAve_base ( resultSet.getString ( "ave_base" ) );

                persons.add ( person );
            }


        }
        catch (Exception e){

            e.printStackTrace ();
        }
        finally {

            if (resultSet != null){

                try {
                    resultSet.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if (statement != null){

                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if (connection != null){

                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

        }



        return persons;
    }

    @Override
    public void delete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfiguration.getConnction ();
            preparedStatement = connection.prepareStatement ( "DELETE FROM person where id = ?" );
            preparedStatement.setInt ( 1 , id );
            preparedStatement.executeUpdate (  );
            System.out.println ( "DELETE FROM person where id = ?" );

        }
        catch (Exception e){

            e.printStackTrace ();
        }
        finally {

            if ( preparedStatement != null){

                try {
                    preparedStatement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if ( connection != null){

                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

        }

    }

    @Override
    public void update(Person person , int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfiguration.getConnction ();
            preparedStatement = connection.prepareStatement ( "UPDATE person SET " +
                    "first_name = ? , last_name = ? , age = ? , base = ? , ave_base = ?  WHERE id = ?");

            preparedStatement.setString ( 1 , person.getFirstName () );
            preparedStatement.setString ( 2 , person.getLastName ());
            preparedStatement.setString ( 3 , person.getAge () );
            preparedStatement.setString ( 4 , person.getBase () );
            preparedStatement.setString ( 5 , person.getAve_base ());
            preparedStatement.setInt ( 6 , id );

            preparedStatement.executeUpdate (  );
            System.out.println ( "UPDATE person SET " +
                    "first_name = ? , last_name = ? , age = ? , base = ? , ave_base = ?  WHERE id = ?");

        }
        catch (Exception e){

            e.printStackTrace ();
        }
        finally {

            if ( preparedStatement != null){

                try {
                    preparedStatement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if ( connection != null){

                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }

        }
    }
}
