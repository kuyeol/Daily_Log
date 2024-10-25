package com.fkereki.mvpproject.client.cityCreator;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.fkereki.mvpproject.client.countryState.CountryStateDisplay;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CityCreatorView
    extends View
    implements CityCreatorDisplay {
  @UiTemplate("CityCreatorView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, CityCreatorView> {
  }

  @UiField
  CountryStateDisplay countryState;

  @UiField
  TextBox cityName;

  @UiField
  TextBox cityAccentedName;

  @UiField
  TextBox cityPopulation;

  @UiField
  TextBox cityLatitude;

  @UiField
  TextBox cityLongitude;

  @UiField
  Button addCityButton;

  SimpleCallback<Object> onAddClickCallback;
  SimpleCallback<Object> onCountryStateChangeCallback;
  SimpleCallback<Object> onCityNameChangeCallback;

  private static final Binder binder = GWT.create(Binder.class);

  public CityCreatorView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public String getAccentedCityName() {
    return cityAccentedName.getValue();
  }

  @Override
  public String getCityName() {
    return cityName.getValue();
  }

  @Override
  public CountryStateDisplay getCountryState() {
    return countryState;
  }

  @Override
  public float getLatitude() {
    return Float.parseFloat(cityLatitude.getValue());
  }

  @Override
  public float getLongitude() {
    return Float.parseFloat(cityLongitude.getValue());
  }

  @Override
  public int getPopulation() {
    return Integer.parseInt(cityPopulation.getValue());
  }

  @Override
  public void setCityNameCssStyle(String css) {
    cityName.setStyleName(css);
  }

  @Override
  public void setOnAddClickCallback(SimpleCallback<Object> acb) {
    onAddClickCallback = acb;
  }

  @Override
  public void setOnCityNameChangeCallback(SimpleCallback<Object> acb) {
    onCityNameChangeCallback = acb;
  }

  @Override
  public void setOnCountryStateChangeCallback(SimpleCallback<Object> acb) {
    onCountryStateChangeCallback = acb;
  }

  @UiHandler("addCityButton")
  void uiOnAddCityClick(ClickEvent event) {
    onAddClickCallback.onSuccess(null);
  }

  @UiHandler("countryState")
  void uiOnChange(ValueChangeEvent<Object> event) {
    onCountryStateChangeCallback.onSuccess(null);
  }

  @UiHandler("cityName")
  void uiOnCityChange(ChangeEvent event) {
    onCityNameChangeCallback.onSuccess(null);
  }
}