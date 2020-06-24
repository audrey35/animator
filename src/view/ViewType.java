package view;

public enum ViewType {
  SVG("svg"), VISUAL("visual");

  private final String viewType;

  /**
   * Constructs an enum.
   *
   * @param type string for enum.
   */
  ViewType(String type) {
    this.viewType = type;
  }

  @Override
  public String toString() {
    return viewType;
  }

  /**
   * Returns the enum for the giving string.
   *
   * @param viewType String representation of the view type.
   * @return The enum for the given string.
   * @throws IllegalArgumentException if the provided string does not represent a view type.
   */

  public static ViewType fromString(String viewType) {
    if (viewType.equalsIgnoreCase("svg")) {
      return SVG;
    } else if (viewType.equalsIgnoreCase("visual")) {
      return VISUAL;
    }
    return null;
  }
}
