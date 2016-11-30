package gonzalo.ejemploutn.objetos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gonza on 22/03/2016.
 */
@Table(name = "Producto")
public class Producto extends Model
{
    @Column(name = "productCode")
    String productCode;
    @Column(name = "productRealCode")
    String productRealCode;
    @Column(name = "productDescription")
    String productDescription;
    @Column(name = "productBrandCode")
    String productBrandCode;
    @Column(name = "productBusinessCode")
    String productBusinessCode;
    @Column(name = "productIVA")
    double productIVA;
    @Column(name = "productModified")
    String productModified;
    @Column(name = "productPrice")
    double productPrice;
    @Column(name = "productBrandDescription")
    String productBrandDescription;

    public String getProductBrandDescription() {
        return productBrandDescription;
    }

    public void setProductBrandDescription(String productBrandDescription) {
        this.productBrandDescription = productBrandDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductRealCode() {
        return productRealCode;
    }

    public void setProductRealCode(String productRealCode) {
        this.productRealCode = productRealCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductBrandCode() {
        return productBrandCode;
    }

    public void setProductBrandCode(String productBrandCode) {
        this.productBrandCode = productBrandCode;
    }

    public String getProductBusinessCode() {
        return productBusinessCode;
    }

    public void setProductBusinessCode(String productBusinessCode) {
        this.productBusinessCode = productBusinessCode;
    }

    public double getProductIVA() {
        return productIVA;
    }

    public void setProductIVA(double productIVA) {
        this.productIVA = productIVA;
    }

    public String getProductModified() {
        return productModified;
    }

    public void setProductModified(String productModified) {
        this.productModified = productModified;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
