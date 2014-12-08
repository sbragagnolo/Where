package es.com.donde.app.components.listadapter;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;



public abstract class ExpandableListAdapter<ChildType> extends BaseExpandableListAdapter {


    public interface ModelType<T> {
        T getChild(int i);
        int getChildrenCount();
    }

    protected Activity context;
    private List<ModelType<ChildType>> models;

    public ExpandableListAdapter () {}
    public ExpandableListAdapter(Activity context, List<ModelType<ChildType>> models) {
        this();
        this.context = context;
        this.models = models;
    }

    public void setModels(List<ModelType<ChildType>> models) {
        this.models = models;
    }

    public ChildType getChild(int groupPosition, int childPosition) {
        return models.get(groupPosition).getChild(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        if (convertView != null) throw new RuntimeException("ConvertView !=null is not supported");
        ChildType child = this.getChild(groupPosition, childPosition);
        return this.drawChildView(child, isLastChild, parent);

    }

    public int getChildrenCount(int groupPosition) {
        return this.models.get(groupPosition).getChildrenCount();
    }

    public ModelType<ChildType> getGroup(int groupPosition) {
        return models.get(groupPosition);
    }

    public int getGroupCount() {
        return models.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ModelType<ChildType> selected = getGroup(groupPosition);
        View drawed = this.drawGroupView(selected, isExpanded, parent);
       // if (convertView != null) convertView.addV

        return drawed;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    abstract public View drawGroupView ( ModelType<ChildType> model, boolean isExpanded, ViewGroup parent);
    abstract public View drawChildView ( ChildType childModel, boolean isLast, ViewGroup parent);
}
