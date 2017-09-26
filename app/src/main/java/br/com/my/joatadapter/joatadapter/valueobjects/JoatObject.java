package br.com.my.joatadapter.joatadapter.valueobjects;

import android.support.annotation.Nullable;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by yasmin on 25/09/17.
 */

public class JoatObject implements Serializable {


    private long headerType;
    private String headerTitle;
    private int bindingRes;
    private int headerBindingRes;
    private Integer bindingHeaderID;
    private Integer bindingObjectID;
    private Object bindingObject;
    private Object bindingHeaderObject;
    private int deletable;

    public JoatObject() {
    }

    /**
     *
     *
     * @param bindingRes É o resource do layout que ira ser inflado em sua row.<br/> <b>EX: R.layout.row_simple</b>
     * @param bindingObjectID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObject É o Objeto que será atribuido ao seu XML. <br/> <b>simpleObject</b>
     * @param headerTitle É o Título do seu Header, um grupo de objetos com o mesmo Header irão estar agrupados sobre o mesmo. Este atributo poderá ser nulo caso não haja a necessidade de um Header. <br/> <b>EX: "Titulo Simples"</b>
     */
    public JoatObject(@NotNull Integer bindingRes, @NotNull Integer bindingObjectID, @NotNull Object bindingObject, @Nullable String headerTitle) {
        this.bindingRes = bindingRes;
        this.headerTitle = headerTitle;
        this.headerType = this.headerTitle == null ? 0 : this.headerTitle.hashCode();
        this.bindingObjectID = bindingObjectID;
        this.bindingObject = bindingObject;
        this.deletable = View.GONE;
        this.headerBindingRes = -1;
        this.bindingHeaderID = -1;
    }

    /**
     *
     * @param bindingRes É o resource do layout que ira ser inflado em sua row.<br/> <b>EX: R.layout.row_simple</b>
     * @param bindingObjectID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObject É o Objeto que será atribuido ao seu XML. <br/> <b>simpleObject</b>
     * @param headerTitle É o Título do seu Header, um grupo de objetos com o mesmo Header irão estar agrupados sobre o mesmo. Este atributo poderá ser nulo caso não haja a necessidade de um Header. <br/> <b>EX: "Titulo Simples"</b>
     * @param deletable Caso queira um header com a opção de deletar.
     */
    public JoatObject(@NotNull Integer bindingRes, @NotNull Integer bindingObjectID, @NotNull Object bindingObject, @NotNull String headerTitle, @NotNull boolean deletable) {
        this.bindingRes = bindingRes;
        this.headerTitle = headerTitle;
        this.headerType = this.headerTitle == null ? 0 : this.headerTitle.hashCode();
        this.bindingObjectID = bindingObjectID;
        this.bindingObject = bindingObject;
        this.deletable = deletable? View.VISIBLE:View.GONE;
        this.headerBindingRes = -1;
        this.bindingHeaderID = -1;
    }

    /**
     *
     * @param headerTitle É o Título do seu Header, um grupo de objetos com o mesmo Header irão estar agrupados sobre o mesmo. Este atributo poderá ser nulo caso não haja a necessidade de um Header. <br/> <b>EX: "Titulo Simples"</b>
     * @param bindingRes É o resource do layout que ira ser inflado em sua row.<br/> <b>EX: R.layout.row_simple</b>
     * @param headerBindingRes É o resource do layout que ira ser inflado em seu header.<br/> <b>EX: R.layout.header_simple</b>
     * @param bindingObjectID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObject É o Objeto que será atribuido ao seu XML. <br/> <b>simpleObject</b>
     */
    public JoatObject(int bindingRes, int headerBindingRes, Integer bindingObjectID, Object bindingObject,String headerTitle) {
        this.headerTitle = headerTitle;
        this.bindingRes = bindingRes;
        this.headerBindingRes = headerBindingRes;
        this.bindingHeaderID = -1;
        this.bindingObjectID = bindingObjectID;
        this.bindingObject = bindingObject;
        this.headerType = this.headerTitle == null ? 0 : this.headerTitle.hashCode();
        this.deletable = View.GONE;
    }

    /**
     *
     * @param bindingRes É o resource do layout que ira ser inflado em sua row.<br/> <b>EX: R.layout.row_simple</b>
     * @param headerBindingRes É o resource do layout que ira ser inflado em seu header.<br/> <b>EX: R.layout.header_simple</b>
     * @param bindingHeaderID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML do header</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObjectID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObject É o Objeto que será atribuido ao seu XML. <br/> <b>simpleObject</b>
     * @param bindingHeaderObject É o Objeto que será atribuido ao seu XML do header. <br/> <b>simpleObject</b>
     * @param headerTitle É o Título do seu Header, um grupo de objetos com o mesmo Header irão estar agrupados sobre o mesmo. Este atributo poderá ser nulo caso não haja a necessidade de um Header. <br/> <b>EX: "Titulo Simples"</b>
     */
    public JoatObject(int bindingRes, int headerBindingRes, Integer bindingHeaderID, Integer bindingObjectID, Object bindingObject, Object bindingHeaderObject, String headerTitle) {
        this.bindingRes = bindingRes;
        this.headerBindingRes = headerBindingRes;
        this.bindingHeaderID = bindingHeaderID;
        this.bindingObjectID = bindingObjectID;
        this.bindingObject = bindingObject;
        this.bindingHeaderObject = bindingHeaderObject;
        this.headerTitle = headerTitle;
        this.headerType = this.headerTitle == null ? 0 : this.headerTitle.hashCode();
        this.deletable = View.GONE;
    }

    public int getHeaderBindingRes() {
        return headerBindingRes;
    }

    public void setHeaderBindingRes(int headerBindingRes) {
        this.headerBindingRes = headerBindingRes;
    }

    public long getHeaderType() {
        return headerType;
    }

    public void setHeaderType(long headerType) {
        this.headerType = headerType;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public int getBindingRes() {
        return bindingRes;
    }

    public void setBindingRes(int bindingRes) {
        this.bindingRes = bindingRes;
    }

    public Integer getBindingObjectID() {
        return bindingObjectID;
    }

    public void setBindingObjectID(Integer bindingObjectID) {
        this.bindingObjectID = bindingObjectID;
    }

    public Object getBindingObject() {
        return bindingObject;
    }

    public void setBindingObject(Object bindingObject) {
        this.bindingObject = bindingObject;
    }

    public int getDeletable() {
        return deletable;
    }

    public void setDeletable(int deletable) {
        this.deletable = deletable;
    }

    public Integer getBindingHeaderID() {
        return bindingHeaderID;
    }

    public void setBindingHeaderID(Integer bindingHeaderID) {
        this.bindingHeaderID = bindingHeaderID;
    }

    public Object getBindingHeaderObject() {
        return bindingHeaderObject;
    }

    public void setBindingHeaderObject(Object bindingHeaderObject) {
        this.bindingHeaderObject = bindingHeaderObject;
    }
}
