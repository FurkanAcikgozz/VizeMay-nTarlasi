package vizemayintarlasi;

import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmVizeMayin extends javax.swing.JFrame {

    final int genislik = 10,yukseklik=10,bomba=3;
    JToggleButton[][] blok =new JToggleButton[yukseklik][genislik];
    int[][] blox = new int [yukseklik][genislik];
    boolean ilk,canPlay; 
    
    ActionListener listen=new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int i=0,j=0;
            boolean found=false;

            for (i = 0; i < yukseklik; i++) {
               // boolean found=false;
                for (j = 0; j < genislik; j++) {
                    if (e.getSource()==blok[i][j]) {
                        found =true;
                        break;
                    }
                }
                if (found) break;
            }
            if(canPlay){
                blok[i][j].setSelected(true) ;
                    if (!ilk) {
                        spawn(i,j);
                        ilk=true;
                 }
                    if (blox[i][j]!=-1) {
                    open(i,j);
                    reval();
                }else kaybettin();
              kazanmak();
            }else reval();
           
        }
    };
    private void kaybettin(){
        canPlay =false;
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if (blox[i][j]==-1) {
                    blok[i][j].setText("Patladın...:(");
                    blok[i][j].setSelected(true);
 
                    
                }
                
            }
        }
    }
    
    private void kazanmak(){
        boolean kazan=true;
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if (blox[i][j]==0) {
                    kazan=false;
                    break;
                }
            }
            if (!kazan) break;
        }
        if (kazan){
            javax.swing.JOptionPane.showMessageDialog(null, "Tebrikler Kazandınız...!"); 
            canPlay=false;
        }
        
    }
    
    
    private void open(int y, int x){
        if (y<0 || x<0 || x>genislik-1 || y>yukseklik-1 || blox[y][x]!=0) {
            return;
        }
        int bombs=0;
        for (int i = y-1; i <= y+1; i++) {
            for (int j = x-1; j <= x+1; j++) {
                if (!(j<0 || i<0 || j>genislik-1 || i> yukseklik-1)&& blox[i][j]==-1) 
                    bombs++;
                
            }
        }
      
        if (bombs==0) {
            blox[y][x]=-2;
            for (int i = y-1; i <= y+1; i++) {
                for (int j = x-1; j <= x+1; j++) {
                    if (!(j<0 || i<0 || j>genislik-1 || i> yukseklik-1))
                    if (i!=y || j!=x) open(i,j);

                }
                
            }
            
        }else blox[y][x]=bomba;
    }
    private void reval(){
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if (blox[i][j]==0) {
                    blok[i][j].setText("");
                    blok[i][j].setSelected(false);
                }
                if (blox[i][j]==-2) {
                    blok[i][j].setText("");
                    blok[i][j].setSelected(true);
                }
                if (blox[i][j]>0) {
                    blok[i][j].setText(""+blox[i][j]);
                    blok[i][j].setSelected(true);
                }
                if (!canPlay && blox[i][j]==-1) blok[i][j].setSelected(true); {
                    
                }
            }
        }
    }
    private void spawn (int x, int y){
        for (int k = 1; k <= bomba; k++) {
            int i;
            int j;
            do {
                i=(int)(Math.random()*(genislik-.01));
                j=(int)(Math.random()*(yukseklik-.01));
  
            }
            while(blox[i][j]==-1 || i==y && j==x);
            blox[i][j]=-1;
          //  blok[i][j].setText("Patladın..:)");

        }
        
    }
    
    public frmVizeMayin() {
        initComponents();
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                blok[i][j]=new JToggleButton();
                blok[i][j].setSize(jPanel1.getWidth()/genislik, jPanel1.getHeight()/yukseklik);
                jPanel1.add(blok[i][j]);
                blok[i][j].setLocation(j*jPanel1.getWidth()/genislik, i*jPanel1.getHeight()/yukseklik);
                blok[i][j].addActionListener(listen);
            }
        }
        ilk=false;
        canPlay=true;
    }
    public void GelBoyut(){
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                blok[i][j].setSize(jPanel1.getWidth()/genislik, jPanel1.getHeight()/yukseklik);
                jPanel1.add(blok[i][j]);
                blok[i][j].setLocation(j*jPanel1.getWidth()/genislik, i*jPanel1.getHeight()/yukseklik);
         }
     }
  }
    

   // public frmVizeMayin() {
      //  initComponents();
   // }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        jMenu1.setText("Oyun");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Yeni Oyun");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        GelBoyut();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        blox=new int[yukseklik][genislik];
        reval();
        canPlay=true;
        ilk=false;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVizeMayin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
