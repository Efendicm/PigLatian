import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class PigLatin {
public static void main(String[] args)
   {
      Pig3Frame frame = new Pig3Frame();
      frame.setTitle("Pig Latin Translator");
      frame.pack();
      frame.show();
   }
}

class Pig3Frame extends JFrame implements KeyListener
{
   final String BANNER = "Translate English to Pig Latin\n";
   final String PROMPT = "Enter English words To Translate Please\n";

   private JTextArea Text;

   public Pig3Frame()
   {
      Text = new JTextArea(100, 100);
      Text.append(PROMPT);
      Text.setCaretPosition(Text.getText().length());
      Text.setEditable(true);
      Text.requestFocus();
      this.addWindowListener(new WindowCloser());
      Text.addKeyListener(this);


      JPanel textPanel = new JPanel();
      textPanel.add(Text);
      

      Container c = getContentPane();
      c.add(textPanel, "Center");
   }

   public void keyReleased(KeyEvent r) {}
   public void keyTyped(KeyEvent r) {}

   public void keyPressed(KeyEvent r)
   {
      if (r.getKeyCode() == KeyEvent.VK_ENTER)
      {
         String e = Text.getText();

         int idx = e.length() - 1;
         while (e.charAt(idx) != '\n')
            --idx;

         e = e.substring(idx, e.length());

         e = translatePhrase(e);

         Text.append("\n" + e);
      }
   }


   private class WindowCloser extends WindowAdapter
   {
      public void windowClosing(WindowEvent event)
      {
         System.exit(0);
      }
   }

   public static String translatePhrase(String s)
   {
      StringTokenizer translator = new StringTokenizer(s);

      String translation = "";
      while (translator.hasMoreTokens())
      {
         String word = translator.nextToken();
         String pigLatinWord = translateWord(word);
         translation += pigLatinWord + " ";
      }
      return translation;
   }

   private static String translateWord(String s)
   {
      String s1 = s.length() > 1 ? s.substring(1, s.length()) : "";
      String s2 = s.length() > 0 ? s.substring(0, 1) : "";
      String s3 = "ay";
      return s1 + s2 + s3;
   }
}
