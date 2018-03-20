public class Symbol {
    protected String name;
    protected ValueType type;
    protected List<ValueType> params;
    protected Object value;
    protected Int adresse;

    public Symbol(String name,ValueType type, List<ValueType> params, Object value, Int adresse) {
      this.name = name;
      this.type = type;
      this.params = params;
      this.value = value;
      this.adresse = adresse;
    }
}