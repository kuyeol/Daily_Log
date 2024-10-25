package com.fkereki.mvpproject.client.clientSearch;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class ClientSearchView
    extends View
    implements ClientSearchDisplay {

  SimpleCallback<Object> searchClickCallback;

  final TextBox nameLike = new TextBox();
  final TextBox addressLike = new TextBox();
  final TextBox cityLike = new TextBox();

  final ListBox clientResults = new ListBox();
  final Button searchButton = new Button("Search");
  final Button returnButton = new Button("Return");
  final Button cancelButton = new Button("Cancel");

  final HorizontalPanel horiz = new HorizontalPanel();
  final FlexTable flex = new FlexTable();
  final FlexTable flex2 = new FlexTable();

  public ClientSearchView() {
    clientResults.setWidth("100%");

    flex.setWidget(0, 0, new Label("Name like:"));
    flex.setWidget(0, 1, nameLike);

    flex.setWidget(1, 0, new Label("Address like:"));
    flex.setWidget(1, 1, addressLike);

    flex.setWidget(2, 0, new Label("City like:"));
    flex.setWidget(2, 1, cityLike);

    horiz.setWidth("100%");
    horiz.add(searchButton);
    horiz.add(returnButton);
    horiz.add(cancelButton);

    flex2.setWidth("100%");
    flex2.getColumnFormatter().setWidth(0, "60%");
    flex2.getColumnFormatter().setWidth(1, "40%");
    flex2.setWidget(0, 0, clientResults);
    flex2.setWidget(0, 1, horiz);

    flex.getFlexCellFormatter().setColSpan(3, 0, 2);
    flex.setWidget(3, 0, flex2);

    initWidget(flex);
  }
}
