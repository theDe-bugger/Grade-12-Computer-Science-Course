
import javax.swing.JOptionPane;

/**
 * This is a program which sorts a random list of numbers (the size of which the user inputs) through different sort methods.
 * 
 * date         20201031
 * @filename	SortingRoutines.java
 * @author      jdalwadi
 * @version     1.0
 * @see         assignment 3.4.1
 */

public class SortingRoutines extends javax.swing.JFrame {

    
    public int[] randomList(int amount){
        int [] randomList = new int[amount];
        int min = -1000;
        int max = 1000;
        // puts a random number in the given range for each index in the array
        for (int i = 0; i < amount; i++){
            randomList[i] = (int)(Math.random()*((max-min)+1))+min; // used https://dzone.com/articles/random-number-generation-in-java#:~:text=Java%20provides%20the%20Math%20class,0.0%20and%20less%20than%201.0.
        }
        return randomList;
    }
    
    public int[] selection(int [] randomList, String type){
        // used 3.4 content as reference

        int [] outputList = randomList;
        int amount = randomList.length;
        if (type.equals("ascending")){
            for (int i = 0; i < amount; i++){
                for (int j = i + 1; j <amount; j++){
                    // goes through array and finds smallest value, and places at the beginning
                    if(outputList[i]>outputList[j]){
                        int temp = outputList[i];
                        outputList[i] = outputList[j];
                        outputList[j] = temp;
                    }
                }
            }
        
        } else if (type.equals("descending")){
            for (int i = 0; i < amount; i++){
                for (int j = i + 1; j <amount; j++){
                    // goes through array and finds biggest value, and places at the beginning
                    if(outputList[i]<outputList[j]){
                        int temp = outputList[i];
                        outputList[i] = outputList[j];
                        outputList[j] = temp;
                    }
                }
            }
        }
        return outputList;
    }
    public int[] bubble(int [] randomList,String type){
        // used 3.4 content as reference
        int [] outputList = randomList;
        int amount = outputList.length;
        if (type.equals("ascending")){
            int bottom = amount -1;
            boolean swap = true;
            while (swap == true){
                swap = false;
                // goes through array, compares element wiht next element, swaps if smaller, keeps doing this until it can no longer be done
                for (int j = 0; j < bottom; j++){
                    if (outputList[j] > outputList[j+1]){ 
                        // swap arr[j+1] and arr[j] 
                        swap = true;
                        int temp = outputList[j]; 
                        outputList[j] = outputList[j+1]; 
                        outputList[j+1] = temp; 
                    }
                    
                }
                bottom = bottom -1;
            }
        } else if (type.equals("descending")){
            int bottom = amount -1;
            boolean swap = true;
            while (swap == true){
                swap = false;
                // goes through array, compares element wiht next element, swaps if bigger, keeps doing this until it can no longer be done
                for (int j = 0; j < bottom; j++){
                    if (outputList[j] < outputList[j+1]){ 
                        // swap arr[j+1] and arr[j] 
                        swap = true;
                        int temp = outputList[j]; 
                        outputList[j] = outputList[j+1]; 
                        outputList[j+1] = temp; 
                    }
                    
                }
                bottom = bottom -1;
            }
        }
        return outputList;
    }
     public static int partition(int[] outputList,String type, int start, int end){
         // used https://www.programcreek.com/2012/11/quicksort-array-in-java/ as refernece
        int pivot = outputList[end];
        if (type.equals("ascending")){
        for(int i=start; i<end; i++){
            if(outputList[i]<pivot){
                int temp= outputList[start];
                outputList[start]=outputList[i];
                outputList[i]=temp;
                start++;
            }
        }
        } else if (type.equals("descending")){
            for(int i=start; i<end; i++){
            if(outputList[i]>pivot){
                int temp= outputList[start];
                outputList[start]=outputList[i];
                outputList[i]=temp;
                start++;
            }
        }
        }
 
        int temp = outputList[start];
        outputList[start] = pivot;
        outputList[end] = temp;
 
        return start;
    }
    public int[] quick(int [] randomList, String type, int start, int end){
        // used https://www.programcreek.com/2012/11/quicksort-array-in-java/ as reference
        int [] outputList = randomList;
        int partition = partition(outputList,type, start, end);
        if(partition-1>start) {
            quick(outputList,type, start, partition - 1);
        }
        if(partition+1<end) {
            quick(outputList,type, partition + 1, end);
        }
        return outputList;
    }
    public int[] insertion(int [] randomList, String type){
        int [] outputList = randomList;
        int amount = outputList.length;
        if (type.equals("ascending")){
            for (int n = 1; n < amount; n++){
                int j = n;
                // goes through array and places elements relative to each other (first is smaller than next), and goes through again if necessary
                while ((j > 0) && (outputList[j-1] > outputList[j])){
                    int temp = outputList[j];
                    outputList[j] = outputList[j-1];
                    outputList[j-1] = temp;
                    j = j-1;
                }
            }
        } else if (type.equals("descending")){
            for (int n = 1; n < amount; n++){
                int j = n;
                // goes through array and places elements relative to each other (first is bigger than next), and goes through again if necessary
                while ((j > 0) && (outputList[j-1] < outputList[j])){
                    int temp = outputList[j];
                    outputList[j] = outputList[j-1];
                    outputList[j-1] = temp;
                    j = j-1;
                }
            }
        }
        return outputList;
    }
    
    public String stringValue(int[] array) {
        String list = "";
        for (int i = 0; i < array.length; i++) {
            list = list + (Integer.toString(array[i])) + "\n";
        }
        return list;
    }
    /**
     * Creates new form SortingRoutines
     */
    public SortingRoutines() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sortSelection = new javax.swing.JRadioButton();
        sortBubble = new javax.swing.JRadioButton();
        sortInsertion = new javax.swing.JRadioButton();
        sortQuick = new javax.swing.JRadioButton();
        ascending = new javax.swing.JRadioButton();
        descending = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        btnSort = new javax.swing.JButton();
        txtAmount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSorted = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOriginal = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Sorting Routines");

        jLabel2.setText("Enter the following information:");

        jLabel3.setText("Sorting Algorithm:");

        jLabel4.setText("Sort Order:");

        buttonGroup1.add(sortSelection);
        sortSelection.setText("Selection");

        buttonGroup1.add(sortBubble);
        sortBubble.setText("Bubble");

        buttonGroup1.add(sortInsertion);
        sortInsertion.setText("Insertion");

        buttonGroup1.add(sortQuick);
        sortQuick.setText("Quick");

        buttonGroup2.add(ascending);
        ascending.setText("Ascending");

        buttonGroup2.add(descending);
        descending.setText("Descending");

        jLabel5.setText("Amount of numbers to sort:");

        btnSort.setText("Sort Numbers");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        txtAmount.setColumns(5);

        jLabel6.setText("Original Numbers:");

        jLabel7.setText("Sorted Numbers:");

        txtSorted.setEditable(false);
        txtSorted.setColumns(10);
        txtSorted.setRows(100);
        jScrollPane1.setViewportView(txtSorted);

        txtOriginal.setEditable(false);
        txtOriginal.setColumns(10);
        txtOriginal.setRows(100);
        jScrollPane2.setViewportView(txtOriginal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sortBubble)
                            .addComponent(sortSelection)
                            .addComponent(sortInsertion)
                            .addComponent(sortQuick)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ascending)
                                    .addComponent(descending))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSort))
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(sortSelection)
                    .addComponent(ascending))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortBubble)
                    .addComponent(descending))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortInsertion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortQuick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnSort)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        try{
        txtOriginal.setText("");
        txtSorted.setText("");

        int amount = Integer.parseInt(txtAmount.getText());
        int [] randomList = randomList(amount);
        txtOriginal.setText(stringValue(randomList));
        int [] output = new int [randomList.length];
        String type;

        if (ascending.isSelected()){
            type = "ascending";
            if (sortSelection.isSelected()){
                output = selection(randomList,type);
            } else if (sortBubble.isSelected()){
                output = bubble(randomList,type);
            } else if (sortInsertion.isSelected()){
                output = insertion(randomList,type);
            } else if (sortQuick.isSelected()){
                output = quick(randomList,type, 0, randomList.length-1);
            }
            txtSorted.setText(stringValue(output));

        } else if (descending.isSelected()){
            type = "descending";
            if (sortSelection.isSelected()){
                output = selection(randomList,type);
            } else if (sortBubble.isSelected()){
                output = bubble(randomList,type);
            } else if (sortInsertion.isSelected()){
                output = insertion(randomList,type);
            } else if (sortQuick.isSelected()){
                output = quick(randomList,type, 0, randomList.length-1);
            } 
            txtSorted.setText(stringValue(output));
            
        } else{
            txtOriginal.setText("");
            txtSorted.setText("");
            JOptionPane.showMessageDialog(null, "Make sure to select a sort method and type.");
        }
        } catch (Exception e){
            txtAmount.setText("");
            txtOriginal.setText("");
            txtSorted.setText("");
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            JOptionPane.showMessageDialog(null, "Please enter a valid whole number amount. Make sure to select a sort method and type.");
        }
    }//GEN-LAST:event_btnSortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SortingRoutines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortingRoutines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortingRoutines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortingRoutines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingRoutines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascending;
    private javax.swing.JButton btnSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton descending;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton sortBubble;
    private javax.swing.JRadioButton sortInsertion;
    private javax.swing.JRadioButton sortQuick;
    private javax.swing.JRadioButton sortSelection;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextArea txtOriginal;
    private javax.swing.JTextArea txtSorted;
    // End of variables declaration//GEN-END:variables
}
