/**
 * 
 */
package com.fkereki.mvpproject.client.citiesUpdater;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CitiesUpdaterView
    extends View
    implements CitiesUpdaterDisplay {

  @UiTemplate("CitiesUpdaterView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, CitiesUpdaterView> {
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  TextBox cityNameStart;

  @UiField
  Button getCitiesButton;

  @UiField
  Button updateCitiesButton;

  @UiField
  FlexTable cg;

  SimpleCallback<Object> onGetCitiesClickCallback;
  SimpleCallback<Object> onUpdateCitiesClickCallback;
  SimpleCallback<Object> onCityNameStartChangeCallback;

  public CitiesUpdaterView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
    clearAllCities();
  }

  @Override
  public void clearAllCities() {
    cg.removeAllRows();
    cg.setText(0, 0, "City");
    cg.setText(0, 1, "Country");
    cg.setText(0, 2, "State");
    cg.setText(0, 3, "Population");
  }

  @Override
  public String getCityNameStart() {
    return cityNameStart.getValue();
  }

  @Override
  public int getCityPopulation(int i) {
    String s;
    int pop;
    try {
      s = ((TextBox) cg.getWidget(i, 3)).getValue();
      pop = Integer.parseInt(s);
    } catch (Exception e) {
      pop = 0;
    }

    return pop;
  }

  @Override
  public void setCityData(
      final int i,
      final String cityName,
      final String countryName,
      final String stateName,
      final int population) {

    cg.setText(i, 0, cityName);
    cg.setText(i, 1, countryName);
    cg.setText(i, 2, stateName);

    TextBox popBox = new TextBox();
    popBox.setTextAlignment(TextBox.ALIGN_RIGHT);
    popBox.setValue("" + population);
    cg.setWidget(i, 3, popBox);
  }

  @Override
  public void setOnCityNameStartChangeCallback(
      SimpleCallback<Object> acb) {
    onCityNameStartChangeCallback = acb;
  }

  @Override
  public void setOnGetCitiesClickCallback(SimpleCallback<Object> acb) {
    onGetCitiesClickCallback = acb;
  }

  @Override
  public void setOnUpdateCitiesClickCallback(SimpleCallback<Object> acb) {
    onUpdateCitiesClickCallback = acb;
  }

  @UiHandler("cityNameStart")
  void uiOnChange(ChangeEvent event) {
    onCityNameStartChangeCallback.onSuccess(null);
  }

  @UiHandler("getCitiesButton")
  void uiOnGetClick(ClickEvent event) {
    onGetCitiesClickCallback.onSuccess(null);
  }

  @UiHandler("updateCitiesButton")
  void uiOnUpdateClick(ClickEvent event) {
    onUpdateCitiesClickCallback.onSuccess(null);
  }
}