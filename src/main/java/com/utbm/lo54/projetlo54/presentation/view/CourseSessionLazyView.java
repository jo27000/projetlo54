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
import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.CourseSessionServiceImpl;
import com.utbm.lo54.projetlo54.metier.LocationServiceImpl;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import com.utbm.lo54.projetlo54.presentation.datamodel.LazyCourseSessionDataModel;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "courseSessionLazyView")
@SessionScoped
public class CourseSessionLazyView implements Serializable {

    private LazyDataModel<CourseSession> lazyModel;

    private CourseSession selectedCourseSession;

    private List<CourseSession> filteredCourseSessionList;

    @ManagedProperty("#{courseSessionService}")
    private CourseSessionService courseSessionSrv;
    @ManagedProperty("#{locationService}")
    private LocationService locationSrv;

    @PostConstruct
    public void init() {
        courseSessionSrv = new CourseSessionServiceImpl();
        locationSrv = new LocationServiceImpl();
        lazyModel = new LazyCourseSessionDataModel(courseSessionSrv.getAll(0, 10, null, null));
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

    public List<String> getCities() {

        return locationSrv.getAllCityNames();
    }

    public List<CourseSession> getFilteredCourseSessionList() {
        return filteredCourseSessionList;
    }

    public void setFilteredCourseSessionList(List<CourseSession> filteredCourseSessionList) {
        this.filteredCourseSessionList = filteredCourseSessionList;
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
        FacesMessage msg;
        msg = new FacesMessage("Session selectionnée", ((CourseSession) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
