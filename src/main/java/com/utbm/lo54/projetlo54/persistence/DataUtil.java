/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.Course;
import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.entity.Location;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;

/**
 *
 * @author Jonathan
 */
public class DataUtil {

    private Session session;

    public void initBase() {
        System.out.println("Début de l'initialisation de la base de données...");
        Random randomGenerator = new Random();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(null, "Rouen"));
        locationList.add(new Location(null, "Belfort"));
        locationList.add(new Location(null, "Marseille"));
        locationList.add(new Location(null, "Evreux"));
        locationList.add(new Location(null, "Amiens"));
        locationList.add(new Location(null, "Angers"));
        locationList.add(new Location(null, "Nice"));
        locationList.add(new Location(null, "Grenoble"));
        locationList.add(new Location(null, "Caen"));
        locationList.add(new Location(null, "Lyon"));
        locationList.add(new Location(null, "Strasbourg"));
        locationList.add(new Location(null, "Fecamp"));
        locationList.add(new Location(null, "Toulouse"));
        locationList.add(new Location(null, "Bordeaux"));

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(null, "Plomberie"));
        courseList.add(new Course(null, "Marketing"));
        courseList.add(new Course(null, "Business"));
        courseList.add(new Course(null, "Vente"));
        courseList.add(new Course(null, "Trading"));
        courseList.add(new Course(null, "Mécanique"));
        courseList.add(new Course(null, "Astronomie"));
        courseList.add(new Course(null, "Immobilier"));
        courseList.add(new Course(null, "Jardinage"));
        courseList.add(new Course(null, "Electricité"));
        courseList.add(new Course(null, "Pilotage sur circuit"));
        courseList.add(new Course(null, "Anglais"));
        courseList.add(new Course(null, "Allemand"));
        courseList.add(new Course(null, "Russe"));
        courseList.add(new Course(null, "Chinois"));
        courseList.add(new Course(null, "Coréen"));

        int locId;
        int courseId;
        for (Location loc : locationList) {
            locId = (Integer) session.save(loc);
            loc.setId(locId);
        }

        for (Course c : courseList) {
            courseId = (Integer) session.save(c);
            c.setCode(courseId);
        }
        List<CourseSession> courseSessionList = new ArrayList<>();
        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 1, 8, 8, 0).getTime(), new GregorianCalendar(2018, 1, 8, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 1, 12, 14, 0).getTime(), new GregorianCalendar(2018, 1, 12, 18, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 1, 10, 9, 30).getTime(), new GregorianCalendar(2018, 1, 11, 12, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 3, 1, 8, 0).getTime(), new GregorianCalendar(2018, 3, 1, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 5, 8, 8, 0).getTime(), new GregorianCalendar(2018, 5, 9, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 6, 8, 8, 0).getTime(), new GregorianCalendar(2018, 8, 6, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 1, 8, 8, 0).getTime(), new GregorianCalendar(2018, 1, 8, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 9, 1, 14, 0).getTime(), new GregorianCalendar(2018, 9, 1, 16, 30).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 11, 10, 8, 0).getTime(), new GregorianCalendar(2018, 11, 14, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 12, 5, 8, 0).getTime(), new GregorianCalendar(2018, 12, 6, 18, 30).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        courseSessionList.add(new CourseSession(null, new GregorianCalendar(2018, 12, 5, 8, 0).getTime(), new GregorianCalendar(2018, 12, 14, 16, 0).getTime(),
                courseList.get(randomGenerator.nextInt(courseList.size())), locationList.get(randomGenerator.nextInt(locationList.size()))));

        int courseSessionId;
        for (CourseSession cs : courseSessionList) {
            courseSessionId = (Integer) session.save(cs);
            cs.setId(courseSessionId);
        }
        session.getTransaction().commit();
        session.close();
        System.out.println("Initialisation terminée.");

    }
}
