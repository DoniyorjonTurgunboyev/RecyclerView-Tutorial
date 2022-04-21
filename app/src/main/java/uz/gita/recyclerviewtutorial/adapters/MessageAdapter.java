package uz.gita.recyclerviewtutorial.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.gita.recyclerviewtutorial.R;
import uz.gita.recyclerviewtutorial.data.Message;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.VH> {

    public interface OnClickListener {
        public void onclick(Message m);
    }

    private final ArrayList<Message> list;
    private final OnClickListener listener;

    public MessageAdapter(ArrayList<Message> list, OnClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gmail, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.name.setText(list.get(position).companyName);
        holder.info.setText(list.get(position).info);
        holder.time.setText(list.get(position).time);
        holder.itemView.setOnClickListener(v -> {
            listener.onclick(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView name, info, time;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.company_name);
            info = itemView.findViewById(R.id.info);
            time = itemView.findViewById(R.id.time);
        }
    }
}
