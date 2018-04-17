package com.leon.learnspringmessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public void sendMessage() {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection con = null;
        Session session = null;

        try {
            con = cf.createConnection();
            session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("spitter.queue");
//            Message
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage() {

    }
}
