package model;

/**
 * Created by User on 18.05.2017.
 */
public class ProductType {
    private int typeId;
    private String typeName;
    private ProductView idView;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ProductView getIdView() {
        return idView;
    }

    public void setIdView(ProductView idView) {
        this.idView = idView;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (typeId != that.typeId) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        return idView != null ? idView.equals(that.idView) : that.idView == null;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (idView != null ? idView.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ProductType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", idView=" + idView +
                '}';
    }
}
