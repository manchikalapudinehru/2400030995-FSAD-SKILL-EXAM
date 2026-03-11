package com.klef.fsad.exam;

import com.klef.fsad.exam.BookingHQLDemo.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDemo 
{
public static void main(String[] args) 
{

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();

Transaction tx = session.beginTransaction();

Booking b1 = new Booking("Sai","2026-03-10","Confirmed");
Booking b2 = new Booking("Ravi","2026-03-12","Pending");

session.save(b1);
session.save(b2);

tx.commit();

System.out.println("Records Inserted");

Query<Booking> q = session.createQuery("from Booking", Booking.class);

List<Booking> list = q.list();

for(Booking b : list)
{
System.out.println(b.getId()+" "+b.getName()+" "+b.getDate()+" "+b.getStatus());
}

session.close();
sf.close();

}
}