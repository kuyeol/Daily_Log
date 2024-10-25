package com.fkereki.mvpproject.client;

import com.fkereki.mvpproject.client.changePassword.ChangePasswordFormPresenter;
import com.fkereki.mvpproject.client.changePassword.ChangePasswordFormView;
import com.fkereki.mvpproject.client.citiesBrowser4.CitiesBrowserPresenter;
import com.fkereki.mvpproject.client.citiesBrowser4.CitiesBrowserView;
import com.fkereki.mvpproject.client.citiesUpdater.CitiesUpdaterPresenter;
import com.fkereki.mvpproject.client.citiesUpdater.CitiesUpdaterView;
import com.fkereki.mvpproject.client.cityCreator.CityCreatorPresenter;
import com.fkereki.mvpproject.client.cityCreator.CityCreatorView;
import com.fkereki.mvpproject.client.clientData.ClientDataPresenter;
import com.fkereki.mvpproject.client.clientData.ClientDataView;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchPresenter;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchView;
import com.fkereki.mvpproject.client.dtos.UserPassKeyDto;
import com.fkereki.mvpproject.client.dummyOne.DummyOnePresenter;
import com.fkereki.mvpproject.client.dummyOne.DummyOneView;
import com.fkereki.mvpproject.client.fileDownload.FileDownloadPresenter;
import com.fkereki.mvpproject.client.fileDownload.FileDownloadView;
import com.fkereki.mvpproject.client.fileUpload.FileUploadPresenter;
import com.fkereki.mvpproject.client.fileUpload.FileUploadView;
import com.fkereki.mvpproject.client.i18n.I18nPresenter;
import com.fkereki.mvpproject.client.i18n.I18nView;
import com.fkereki.mvpproject.client.login5.LoginFormPresenter;
import com.fkereki.mvpproject.client.login5.LoginFormView;
import com.fkereki.mvpproject.client.map1.MapPresenter;
import com.fkereki.mvpproject.client.map1.MapView;
import com.fkereki.mvpproject.client.newsReader.NewsReaderPresenter;
import com.fkereki.mvpproject.client.newsReader.NewsReaderView;
import com.fkereki.mvpproject.client.suggest.SuggestPresenter;
import com.fkereki.mvpproject.client.suggest.SuggestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Environment {
  protected class HistoryCommand
      implements Command {
    String historyToken;

    public HistoryCommand(final String newToken) {
      historyToken = newToken;
    }

    public void execute() {
      launch(historyToken);
    }
  }

  final Model model;
  final Grid rootDisplay = new Grid(2, 1);
  final MenuBar runMenuBar = new MenuBar();
  final VerticalPanel runPanel = new VerticalPanel();
  String startingToken;

  String currentUser;
  String currentKey;
  String currentPassword;

  abstract class MyRunAsyncCallback
      implements RunAsyncCallback {

    String myOwnArgs;
    Panel myOwnPanel;
    Environment myOwnEnvironment;
    String myOwnErrorMessage;

    public MyRunAsyncCallback(
        final String args, final Panel panel,
        final Environment environment, final String errorMessage) {

      myOwnArgs = args;
      myOwnPanel = panel;
      myOwnEnvironment = environment;
      myOwnErrorMessage = errorMessage;
    }

    @Override
    public void onFailure(final Throwable reason) {
      myOwnEnvironment.showAlert(myOwnErrorMessage);
    }
  }

  Command sorry = new Command() {
    @Override
    public void execute() {
      showAlert("Sorry, this isn't ready yet.");
    }
  };

  public Environment(final Model aModel, final String aToken) {
    model = aModel;
    startingToken = aToken;
  }

  private void createMenu(final MenuBar mb) {
    // TODO Add user type parameter, for specific menu
    // generation

    mb.addItem("dummy#1", new HistoryCommand(DummyOnePresenter.PLACE
        + "?parameter=value"));
    mb.addItem("Suggest", new HistoryCommand(SuggestPresenter.PLACE));
    mb
        .addItem("Clients", new HistoryCommand(
            ClientDataPresenter.PLACE));

    final MenuBar mb2 = new MenuBar(true);
    mb2.addItem("subitem1", sorry);
    mb2.addItem("subitem2", sorry);
    mb2.addItem("subitem3", sorry);
    mb2.addItem("subitem4", sorry);
    mb.addItem("submenu", mb2);

    final MenuBar mb3 = new MenuBar(true);
    mb3.addItem("Browsing", new HistoryCommand(
        CitiesBrowserPresenter.PLACE));
    mb3.addItem("Creating", new HistoryCommand(
        CityCreatorPresenter.PLACE));
    mb3.addItem("Updating", new HistoryCommand(
        CitiesUpdaterPresenter.PLACE));
    mb3.addItem("Interactive Map", new HistoryCommand(
        MapPresenter.PLACE));

    mb.addItem("Cities", mb3);

    mb.addItem("Hello", new HistoryCommand("SAYHELLO"));

    mb.addItem("Internationalization", new HistoryCommand(
        I18nPresenter.PLACE));

    mb.addItem("News", new HistoryCommand(NewsReaderPresenter.PLACE));

    final MenuBar mb4 = new MenuBar(true);
    mb4.addItem("File Upload", new HistoryCommand(
        FileUploadPresenter.PLACE));
    mb4.addItem("File Download", new HistoryCommand(
        FileDownloadPresenter.PLACE));
    mb.addItem("Files", mb4);

    final MenuBar mbLogin = new MenuBar(true);
    mbLogin.addItem("Change Password", new HistoryCommand(
        ChangePasswordFormPresenter.PLACE));
    mbLogin.addItem("Login again", new HistoryCommand(
        LoginFormPresenter.PLACE));
    mb.addItem("Login", mbLogin);
  }

  public String getCurrentSessionKey() {
    return currentKey;
  }

  public String getCurrentUserName() {
    return currentUser;
  }

  public String getCurrentUserPassword() {
    return currentPassword;
  }

  public Model getModel() {
    return model;
  }

  public void launch(final String token) {
    launch(token, null);
  }

  public void launch(String token, Panel panel) {
    /*
     * There could be parameters after the "#token" in the classic form
     * "?key1=value1&key2=value2..."; for more on this, check
     * http://www.w3.org/TR/hash-in-uri/.
     */
    String args = "";
    final int question = token.indexOf("?");
    if (question != -1) {
      args = token.substring(question + 1);
      token = token.substring(0, question);
    }

    /*
     * If no panel is given, use the standard runPanel, and add the token to
     * History.
     * 
     * Be careful not to forget the "false" parameter in newItem(...), or
     * programs will be called twice!
     */
    if (panel == null) {
      panel = runPanel;
      History.newItem(token, false);
    }
    panel.clear();

    // TODO Check, before running, if the current user is
    // allowed to run the program

    if (token.isEmpty()) {
      // no need to do anything...
    } else if (token.equals(LoginFormPresenter.PLACE)) {
      showLogin(RootPanel.get());
    } else if (token.equals("SAYHELLO")) {
      final HelloBrowser hb = new HelloBrowser();
      hb.salute();
    } else if (token.equals(DummyOnePresenter.PLACE)) {
      panel.add(new DummyOnePresenter(args, new DummyOneView(), this)
          .getDisplay().asWidget());
    } else if (token.equals(SuggestPresenter.PLACE)) {
      panel.add(new SuggestPresenter(args, new SuggestView(), this)
          .getDisplay().asWidget());
    } else if (token.equals(ClientDataPresenter.PLACE)) {
      panel.add(new ClientDataPresenter(args, new ClientDataView(),
          this).getDisplay().asWidget());
    } else if (token.equals(ClientSearchPresenter.PLACE)) {
      panel.add(new ClientSearchPresenter(args, new ClientSearchView(),
          this).getDisplay().asWidget());
    } else if (token.equals(CitiesBrowserPresenter.PLACE)) {
      // panel.add(new CitiesBrowserPresenter(args, new CitiesBrowserView(),
      // this).getDisplay().asWidget());

      GWT.runAsync(new MyRunAsyncCallback(args, panel, this,
          "Couldn't load the cities browser code") {
        public void onSuccess() {
          myOwnPanel.add(new CitiesBrowserPresenter(myOwnArgs,
              new CitiesBrowserView(), myOwnEnvironment).getDisplay()
              .asWidget());
        }
      });

    } else if (token.equals(CityCreatorPresenter.PLACE)) {
      // panel.add(new CityCreatorPresenter(args, new CityCreatorView(),
      // this).getDisplay().asWidget());

      GWT.runAsync(new MyRunAsyncCallback(args, panel, this,
          "Couldn't load the cities browser code") {
        public void onSuccess() {
          myOwnPanel.add(new CityCreatorPresenter(myOwnArgs,
              new CityCreatorView(), myOwnEnvironment).getDisplay()
              .asWidget());
        }
      });

    } else if (token.equals(CitiesUpdaterPresenter.PLACE)) {
      panel.add(new CitiesUpdaterPresenter(args,
          new CitiesUpdaterView(), this).getDisplay().asWidget());
    } else if (token.equals(MapPresenter.PLACE)) {
      panel.add(new MapPresenter(args, new MapView(), this)
          .getDisplay().asWidget());
    } else if (token.equals(NewsReaderPresenter.PLACE)) {
      panel.add(new NewsReaderPresenter(args, new NewsReaderView(),
          this).getDisplay().asWidget());
    } else if (token.equals(ChangePasswordFormPresenter.PLACE)) {
      panel.add(new ChangePasswordFormPresenter(args,
          new ChangePasswordFormView(), this).getDisplay().asWidget());
    } else if (token.equals(I18nPresenter.PLACE)) {
      panel.add(new I18nPresenter(args, new I18nView(), this)
          .getDisplay().asWidget());
    } else if (token.equals(FileUploadPresenter.PLACE)) {
      panel.add(new FileUploadPresenter(args, new FileUploadView(),
          this).getDisplay().asWidget());
    } else if (token.equals(FileDownloadPresenter.PLACE)) {
      panel.add(new FileDownloadPresenter(args, new FileDownloadView(),
          this).getDisplay().asWidget());
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }

  public void setCurrentSessionKey(final String s) {
    currentKey = s;
  }

  public void setCurrentUserName(final String s) {
    currentUser = s;
  }

  public void setCurrentUserPassword(final String s) {
    currentPassword = s;
  }

  public void showAlert(final String alertText) {
    Window.alert(alertText);
  }

  private void showLogin(final Panel panel) {
    setCurrentUserName("");

    final LoginFormPresenter loginForm = new LoginFormPresenter("",
        new LoginFormView(), this,
        new SimpleCallback<UserPassKeyDto>() {
          @Override
          public void goBack(final UserPassKeyDto result) {
            setCurrentUserName(result.user);
            setCurrentUserPassword(result.pass);
            setCurrentSessionKey(result.key);
            showMainMenu();
          }
        });

    panel.clear();
    panel.add(loginForm.getDisplay().asWidget());
  }

  private void showMainMenu() {
    // TODO Use user information for menu configuration

    runMenuBar.clearItems();
    runMenuBar.setWidth("100%");
    createMenu(runMenuBar);

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    RootPanel.get().clear();
    RootPanel.get().add(rootDisplay);

    /*
     * If the application was started with a token, now that the user is logged
     * in, it's time to show it. Don't forget to clear startingToken, or after a
     * logout/login, we will go back again to it.
     */
    if (!startingToken.isEmpty()) {
      launch(startingToken);
      startingToken = "";
    }
  }
}
