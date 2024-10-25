/**
 * 
 */
package com.fkereki.mvpproject.client.suggest;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

/**
 * This class simplifies creating a suggestions list for a SuggestBox
 * 
 * @author fkereki
 */
public class SuggestionItem
    implements Suggestion, IsSerializable {
  private String suggestionText;

  /**
   * An empty constructor is required for serialization!
   */
  public SuggestionItem() {
    super();
  }

  /**
   * Simplify the creation of a straight suggestion item
   */
  public SuggestionItem(String text) {
    super();
    suggestionText = text;
  }

  @Override
  public String getDisplayString() {
    return suggestionText;
  }

  @Override
  public String getReplacementString() {
    return suggestionText;
  }
}