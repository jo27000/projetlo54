/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.presentation.view;

/**
 *
 * @author Jonathan
 */
import com.utbm.lo54.projetlo54.entity.Client;
import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.ClientServiceImpl;
import com.utbm.lo54.projetlo54.metier.CourseServiceImpl;
import com.utbm.lo54.projetlo54.metier.CourseSessionServiceImpl;
import com.utbm.lo54.projetlo54.metier.LocationServiceImpl;
import com.utbm.lo54.projetlo54.metier.interfaces.service.ClientService;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseService;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import com.utbm.lo54.projetlo54.presentation.datamodel.LazyCourseSessionDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "courseSessionLazyView")
@SessionScoped
public class CourseSessionLazyView implements Serializable {

    private LazyDataModel<CourseSession> lazyModel;
    private HashMap<String, String> jedisCoursesMap = new HashMap<>();
    private CourseSession selectedCourseSession;
    private Set<String> courseKeySet = new HashSet<>();
    private ClientService clientSrv;
    private CourseService courseSrv;
    private CourseSessionService courseSessionSrv;
    private LocationService locationSrv;

    private Client client = new Client();
    private Integer registeredCount;

    @PostConstruct
    public void init() {
        courseSessionSrv = new CourseSessionServiceImpl();
        locationSrv = new LocationServiceImpl();
        clientSrv = new ClientServiceImpl();
        lazyModel = new LazyCourseSessionDataModel();
        courseSrv = new CourseServiceImpl();
    }

    public LazyDataModel<CourseSession> getLazyModel() {
        return lazyModel;
    }

    public CourseSession getSelectedCourseSession() {
        return selectedCourseSession;
    }

    public void setSelectedCourseSession(CourseSession selectedCourseSession) {
        this.selectedCourseSession = selectedCourseSession;
    }

    public CourseSessionService getCourseSessionSrv() {
        return courseSessionSrv;
    }

    public ClientService getClientSrv() {
        return clientSrv;
    }

    public void setClientSrv(ClientService clientSrv) {
        this.clientSrv = clientSrv;
    }

    public List<String> getCities() {

        return locationSrv.getAllCityNames();
    }

    public LocationService getLocationSrv() {
        return locationSrv;
    }

    public void setLocationSrv(LocationService locationSrv) {
        this.locationSrv = locationSrv;
    }

    public void setCourseSessionSrv(CourseSessionService courseSessionSrv) {
        this.courseSessionSrv = courseSessionSrv;
    }

    public void onRowSelect(SelectEvent event) {
        registeredCount = clientSrv.getCountByCourseSession(((CourseSession) event.getObject()).getId());
    }

    public void registerUser() {
        client.setCourseSession(selectedCourseSession);
        client.setId(clientSrv.create(client));

        FacesContext context = FacesContext.getCurrentInstance();
        if (client.getId() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur", "Désolé " + client.getFirstName() + ", votre inscription n'a pas pu être effectuée."));
        } else {
            RequestContext.getCurrentInstance().execute("PF('courseSessionDialog').hide()");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inscription réussie", "Votre inscription a bien été effectuée " + client.getFirstName()));
        }

    }

    public void clearDateFilter() {
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("form:courseSessionTable");
        if (dataTable.getFilters().get("startDate") != null) {
            for (Iterator<Map.Entry<String, Object>> it = dataTable.getFilters().entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, Object> entry = it.next();
                if (entry.getKey().equals("startDate")) {
                    it.remove();
                }
            }
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.update("form:courseSessionTable");
        }
    }

    public Integer getRegisteredCount() {
        return registeredCount;
    }

    public void setRegisteredCount(Integer registeredCount) {
        this.registeredCount = registeredCount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public HashMap<String, String> getJedisCoursesMap() {
        return jedisCoursesMap;
    }

    public void setJedisCoursesMap(HashMap<String, String> jedisCoursesMap) {
        this.jedisCoursesMap = jedisCoursesMap;
    }

    public Set<String> getCourseKeySet() {
        return courseKeySet;
    }

    public void setCourseKeySet(Set<String> courseKeySet) {
        this.courseKeySet = courseKeySet;
    }

    public CourseService getCourseSrv() {
        return courseSrv;
    }

    public void setCourseSrv(CourseService courseSrv) {
        this.courseSrv = courseSrv;
    }

    public List<Entry<String, String>> getRedisCourseMapEntryList() {
        courseKeySet = courseSrv.getIdSetWithRedis();
        jedisCoursesMap = new HashMap<>();
        for (String s : courseKeySet) {
            jedisCoursesMap.put(s, courseSrv.getByIdWithRedis(Integer.valueOf(s)));
        }

        return new ArrayList(jedisCoursesMap.entrySet());
    }

}
