import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17413 {
    static ArrayList<Character> list;
    static ArrayList<ArrayList<Character>> temp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        list = new ArrayList<>();
        temp = new ArrayList<>();
        for(int i=0 ; i<str.length() ; i++){
            if(list.isEmpty()){
                list.add(str.charAt(i));
            }
            else{
                if(list.get(0)=='<'){
                    if(str.charAt(i)=='>'){
                        list.add(str.charAt(i));
                        temp.add((ArrayList<Character>)list.clone());
                        list.clear();
                    }
                    else{
                        list.add(str.charAt(i));
                    }
                }
                else {
                    if(str.charAt(i)!=' '){
                        if(str.charAt(i)=='<'){
                            temp.add((ArrayList<Character>)list.clone());
                            list.clear();
                            list.add(str.charAt(i));
                        }
                        else if(i==str.length()-1){
                            list.add(str.charAt(i));
                            temp.add((ArrayList<Character>)list.clone());
                        }
                        else{
                            list.add(str.charAt(i));
                        }

                    }
                    else if (str.charAt(i)==' '){
                        temp.add((ArrayList<Character>)list.clone());
                        list.clear();
                        list.add(' ');
                        temp.add((ArrayList<Character>)list.clone());
                        list.clear();
                    }
                }
            }
        }
        StringBuffer ans = new StringBuffer();
        for(int i=0 ; i<temp.size() ; i++){
            if(temp.get(i).get(0)=='<'){
                for(int j=0 ; j<temp.get(i).size() ; j++){
                    ans.append(temp.get(i).get(j));
                }
            }
            else{
                for(int j=temp.get(i).size()-1 ; j>=0 ; j--){
                    ans.append(temp.get(i).get(j));
                }
            }
        }
        System.out.println(ans);
    }
}
