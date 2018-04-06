package defaut;
import org.antlr.runtime.tree.CommonTree;

private static void analyseRec(CommonTree t,TableSymboles tds, Tables tables){
 if(t.isNil()){
 return;
 }

 if(t.getText().equals("STRUCT"))
 {
   String Name =  t.getChild(0).getText() ;
   int leafnb= t.getChildCount();
   if (leafnb>1){
      for (int i=1;i<leafnb;i++){
        try {
         tds.ajouterVariable(t.getChild(i).getChild(0).getText(),t.getChild(i).getChild(1));
        }
        catch exception{
        }
      }

   }

 }

 if (t.getText().equals("FUNC")){
   String Name =  t.getChild(0).getText();
   String child1= t.getChild(1).getText();
   if (child1.equals("FUNC_ARGS"){

   } else if (child1.equals("BLOC")){

   } else {

   }

 }




}
