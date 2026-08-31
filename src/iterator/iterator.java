package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterator {
    public static void main(String[] args){

        String [] s={"abc","def"};
        Playlist p=new Playlist(s);

        Iterator<String> it=p.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        List<Playlist>play=new ArrayList<>(2);
        play.add(new Playlist(s));
        play.add(new Playlist(s));
        for(Playlist q: play){
            System.out.println(q);
        }
        for(String st: p){
            System.out.println(st);
        }
    }
}

class Playlist implements Iterable<String> {
    private final String[] str;

    Playlist(String[] str){
        this.str=str;
    }

    @Override
    public Iterator<String> iterator(){
        return new PlaylistIterator();
    }

    private class PlaylistIterator implements Iterator<String> {
        int curr=0;

        @Override
        public boolean hasNext(){
            return curr<str.length;
        }

        @Override
        public String next(){
            return str[curr++];
        }
    }
}
