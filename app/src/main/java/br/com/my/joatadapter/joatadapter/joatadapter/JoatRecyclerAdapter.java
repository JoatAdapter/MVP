package br.com.my.joatadapter.joatadapter.joatadapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.my.joatadapter.joatadapter.valueobjects.JoatObject;

/**
 * Created by yasmin on 25/09/17.
 */

public class JoatRecyclerAdapter  extends RecyclerView.Adapter {

    private List<JoatObject> mJoatObjectList;
    protected JoatRecyclerInterface joatRecyclerDelegate;


    /**
     * Construtor para recyclerAdapter
     * @param joatRecyclerDelegate interface para retorno de click no adapter
     */
    public JoatRecyclerAdapter(JoatRecyclerInterface joatRecyclerDelegate){
        this.mJoatObjectList = new ArrayList<>();
        this.joatRecyclerDelegate = joatRecyclerDelegate;
    }




    /**
     * Interface para devolver a posição do click
     */
    public interface JoatRecyclerInterface {
        void itemRecyclerClick(int position);
        void itemRecyclerLongClick(int position);
    }




    /**
     * Recebe uma lista de JoatObject e atualiza os dados da lista, caso haja uma lista anteriormente já setada ela será substituida.
     * @param mJoatObjectList lista de joatObjects
     */
    public void  setData(List<JoatObject> mJoatObjectList){
        this.mJoatObjectList = mJoatObjectList;
        notifyDataSetChanged();
    }




    /**
     * Recebe uma lista de JoatObject e muda os dados da lista, caso haja uma lista anteriormente já setada, a nova será adicioinada na lista anterior.
     * @param joatObjects Uma lista de JoatObject.
     */
    public void addData(List<JoatObject> joatObjects) {
        this.mJoatObjectList.addAll(joatObjects);
        notifyDataSetChanged();
    }




    /**
     * Método que devolve o objeto do adapter
     * @param position posição desejada na lista.
     * @param type tipo de objeto a ser retornado.
     * @return retorna o objeto com o tipo especificado.
     */
    public <T>T getItemWithType(int position, Class<T> type){
        return  type.cast(((JoatObject) getItem(position)).getBindingObject());
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewDataBinding viewDataBinding;
        JoatObject joatObjectFromList = getItem(viewType);
        viewDataBinding = DataBindingUtil.inflate(inflater, joatObjectFromList.getBindingRes(), parent, false);

        return  new JoatRecyclerViewHolder(viewDataBinding);
    }




    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        JoatObject item = getItem(position);
        if (item.getBindingObjectID() != null){
            ((JoatRecyclerViewHolder) holder).view.setVariable(item.getBindingObjectID(),item.getBindingObject());
        }
        ((JoatRecyclerViewHolder) holder).view.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joatRecyclerDelegate.itemRecyclerClick(holder.getAdapterPosition());
            }
        });
        ((JoatRecyclerViewHolder) holder).view.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                joatRecyclerDelegate.itemRecyclerLongClick(holder.getAdapterPosition());
                return true;
            }
        });
    }




    @Override
    public int getItemCount() {
        return mJoatObjectList.size();
    }




    /**
     * Método que retorna o joatObject de acordo com sua posição na lista
     * @param position
     * @return
     */
    protected JoatObject getItem(int position){
        return mJoatObjectList.get(position);
    }



    /**
     * Método que retorna a lista de joatObjects
     * @return
     */
    public List<JoatObject> getData(){
        return mJoatObjectList;
    }


    /**
     * Método que pega o tipo do objeto
     * @param position posicao do objeto na lista
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     * Classe onde é setada a view dos itens de recyclerview
     */
    protected class JoatRecyclerViewHolder extends RecyclerView.ViewHolder {

        public ViewDataBinding view;

        public JoatRecyclerViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            view = viewDataBinding;
        }

    }
}
