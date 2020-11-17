
/**
 * This is a program which sorts a random list of numbers (the size of which the user inputs) through different sort methods.
 * It also outputs the efficiency of each sort method.
 * date         20201031
 * @filename	SortingEfficiencies.java
 * @author      jdalwadi
 * @version     1.0
 * @see         assignment 3.4.2
 */
import javax.swing.JOptionPane;
public class SortingEfficiencies extends javax.swing.JFrame {
    private int loopCount;
    private int comparisonCount;
    private int shiftCount;
    public int amount;
    public String sortMethod;
    public String time;
    public long begin, finish, elapsed;
    public int[] randomList(int amount){
        int [] randomList = new int[amount];
        int min = -10000;
        int max = 10000;
        for (int i = 0; i < amount; i++){
            randomList[i] = (int)(Math.random()*((max-min)+1))+min; // used https://dzone.com/articles/random-number-generation-in-java#:~:text=Java%20provides%20the%20Math%20class,0.0%20and%20less%20than%201.0.
        }
        return randomList;
    }
    
    public int[] selection(int [] randomList, String type){
        sortMethod = "Selection Sort";
        begin = System.currentTimeMillis();
        // used 3.4 content as reference
        int [] outputList = randomList;
        int amount = randomList.length;
        if (type.equals("ascending")){
            for (int i = 0; i < amount; i++){
                for (int j = i + 1; j <amount; j++){
                    comparisonCount++;
                    loopCount++;
                    // goes through array and finds smallest value, and places at the beginning
                    if(outputList[i]>outputList[j]){
                        shiftCount+= 2;
                        int temp = outputList[i];
                        outputList[i] = outputList[j];
                        outputList[j] = temp;
                    } 
                    
                }
            }
        
        } else if (type.equals("descending")){
            for (int i = 0; i < amount; i++){
                for (int j = i + 1; j <amount; j++){
                    comparisonCount++;
                    loopCount++;
                    // goes through array and finds biggest value, and places at the beginning
                    if(outputList[i]<outputList[j]){
                        int temp = outputList[i];
                        outputList[i] = outputList[j];
                        outputList[j] = temp;
                        shiftCount+=2;
                    }
                    
                }
            }
        }
        finish = System.currentTimeMillis();
        elapsed = (finish - begin);
        time = "\nNumber of milliseconds to complete sort: " + String.valueOf(elapsed);
        return outputList;
    }
    public  int[] bubble(int [] randomList,String type){
        sortMethod = "Bubble Sort";
        begin = System.currentTimeMillis();
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
                    comparisonCount++;
                    loopCount++;
                    if (outputList[j] > outputList[j+1]){ 
                        // swap arr[j+1] and arr[j] 
                        swap = true;
                        int temp = outputList[j]; 
                        outputList[j] = outputList[j+1]; 
                        outputList[j+1] = temp; 
                        shiftCount+=2;
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
                    comparisonCount++;
                    loopCount++;
                    if (outputList[j] < outputList[j+1]){ 
                        // swap arr[j+1] and arr[j] 
                        swap = true;
                        int temp = outputList[j]; 
                        outputList[j] = outputList[j+1]; 
                        outputList[j+1] = temp; 
                        shiftCount+=2;
                    }
                    
                }
                bottom = bottom -1;
            }
        }
        finish = System.currentTimeMillis();
        elapsed = (finish - begin);
        time = "\nNumber of milliseconds to complete sort: " + String.valueOf(elapsed);
        return outputList;
    }
    public  int partition(int[] outputList,String type, int start, int end){
         // used https://www.programcreek.com/2012/11/quicksort-array-in-java/ as refernece
        int pivot = outputList[end];
        if (type.equals("ascending")){
        for(int i=start; i<end; i++){
            loopCount++;
            comparisonCount++;
            if(outputList[i]<pivot){
                int temp= outputList[start];
                outputList[start]=outputList[i];
                outputList[i]=temp;
                shiftCount+=2;
                start++;
            }
        }
        } else if (type.equals("descending")){
            for(int i=start; i<end; i++){
            loopCount++;
            comparisonCount++;
            if(outputList[i]>pivot){
                int temp= outputList[start];
                outputList[start]=outputList[i];
                outputList[i]=temp;
                shiftCount+=2;
                start++;
            }
        }
        }
 
        int temp = outputList[start];
        outputList[start] = pivot;
        outputList[end] = temp;
        return start;
    }
    public  int[] quick(int [] randomList, String type, int start, int end){
        sortMethod = "Quick Sort";
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
    public  int[] insertion(int [] randomList, String type){
        sortMethod = "Insertion Sort";
        begin = System.currentTimeMillis();
        int [] outputList = randomList;
        int amount = outputList.length;
        if (type.equals("ascending")){
            for (int n = 1; n < amount; n++){
                int j = n;
                // goes through array and places elements relative to each other (first is smaller than next), and goes through again if necessary
                while ((j > 0) && (outputList[j-1] > outputList[j])){
                    loopCount++;
                    comparisonCount++;
                    int temp = outputList[j];
                    outputList[j] = outputList[j-1];
                    outputList[j-1] = temp;
                    j = j-1;
                    shiftCount+=2;
                }
            }
        } else if (type.equals("descending")){
            for (int n = 1; n < amount; n++){
                int j = n;
                // goes through array and places elements relative to each other (first is bigger than next), and goes through again if necessary
                while ((j > 0) && (outputList[j-1] < outputList[j])){
                    loopCount++;
                    comparisonCount++;
                    int temp = outputList[j];
                    outputList[j] = outputList[j-1];
                    outputList[j-1] = temp;
                    j = j-1;
                    shiftCount+=2;
                }

            }
        }
        finish = System.currentTimeMillis();
        elapsed = (finish - begin);
        time = "\nNumber of milliseconds to complete sort: " + String.valueOf(elapsed);
        return outputList;
         
    }
    public void setResults(){
        // sets output and resets rest of values
        txtResults.setText(txtResults.getText()+"\n"+sortMethod+"\nNumber of times loop was executed: " + String.valueOf(loopCount)+"\nNumber of times a comparison was made: " + String.valueOf(comparisonCount)+"\nNumber of times a value was shifted: " + String.valueOf(shiftCount)+ time + "\n");
        time = "";
        loopCount = 0;
        shiftCount = 0;
        comparisonCount=0;
        elapsed = 0;
        begin = 0;
        finish = 0;
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
    public SortingEfficiencies() {
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
        ten = new javax.swing.JRadioButton();
        hundred = new javax.swing.JRadioButton();
        thousand = new javax.swing.JRadioButton();
        fivethousand = new javax.swing.JRadioButton();
        ascending = new javax.swing.JRadioButton();
        descending = new javax.swing.JRadioButton();
        btnSort = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSorted = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOriginal = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResults = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Sorting Routines");

        jLabel2.setText("Enter the following information:");

        jLabel3.setText("Amount of numbers:");

        jLabel4.setText("Sort Order:");

        buttonGroup1.add(ten);
        ten.setText("10");

        buttonGroup1.add(hundred);
        hundred.setText("100");

        buttonGroup1.add(thousand);
        thousand.setText("1000");

        buttonGroup1.add(fivethousand);
        fivethousand.setText("5000");

        buttonGroup2.add(ascending);
        ascending.setText("Ascending");

        buttonGroup2.add(descending);
        descending.setText("Descending");

        btnSort.setText("Sort Numbers");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

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

        jLabel8.setText("Sort Results:");

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtResults.setEditable(false);
        txtResults.setColumns(20);
        txtResults.setRows(25);
        jScrollPane4.setViewportView(txtResults);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(hundred)
                                                    .addComponent(ten)
                                                    .addComponent(thousand)
                                                    .addComponent(fivethousand))))
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ascending)
                                            .addComponent(descending))))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSort)
                                .addGap(180, 180, 180)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ten))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hundred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thousand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fivethousand)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ascending))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descending)
                                .addGap(70, 70, 70)
                                .addComponent(btnSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(0, 227, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        try{
        txtOriginal.setText("");
        txtSorted.setText("");
        txtResults.setText("");
        int [] output;
        String type;
        if (ascending.isSelected()){
            type = "ascending";
            if (ten.isSelected()){
                amount = 10;
            } else if (hundred.isSelected()){
                amount = 100;
            } else if (thousand.isSelected()){
                amount = 1000;
            } else if (fivethousand.isSelected()){
                amount = 5000;
                
            }
            // creates clones of the random array to be sorted
            int [] randomList = randomList(amount);
            int [] randomList1 = randomList.clone();
            int [] randomList2 = randomList.clone();
            int [] randomList3 = randomList.clone();
            int [] randomList4 = randomList.clone();

            // sets value of the original random array
            txtOriginal.setText(stringValue(randomList));

            // measures time it takes to quick sort
            long begin = System.currentTimeMillis();
            output = quick(randomList1,type, 0, randomList1.length-1);
            long finish = System.currentTimeMillis();
            long elapsed = (finish - begin);
            time = "\nNumber of milliseconds to complete sort: " + String.valueOf(elapsed);
            setResults();

            // sets sorted array
            txtSorted.setText(stringValue(output));

            // calculates results of rest of the sort methods
            output = bubble(randomList2,type);
            setResults();
            output = selection(randomList3,type);
            setResults();
            output = insertion(randomList4,type);
            setResults();
        } else if (descending.isSelected()){
            type = "descending";
            if (ten.isSelected()){
                amount = 10;
            } else if (hundred.isSelected()){
                amount = 100;
            } else if (thousand.isSelected()){
                amount = 1000;
            } else if (fivethousand.isSelected()){
                amount = 5000;
                
            }
            // creates clones of the random array to be sorted
            int [] randomList = randomList(amount);
            int [] randomList1 = randomList.clone();
            int [] randomList2 = randomList.clone();
            int [] randomList3 = randomList.clone();
            int [] randomList4 = randomList.clone();

            // sets value of the original random array
            txtOriginal.setText(stringValue(randomList));

            // measures time it takes to quick sort
            long begin = System.currentTimeMillis();
            output = quick(randomList1,type, 0, randomList1.length-1);
            long finish = System.currentTimeMillis();
            long elapsed = (finish - begin);
            time = "\nNumber of milliseconds to complete sort: " + String.valueOf(elapsed);
            setResults();

            // sets sorted array
            txtSorted.setText(stringValue(output));

            // calculates results of rest of the sort methods
            output = bubble(randomList2,type);
            setResults();
            output = selection(randomList3,type);
            setResults();
            output = insertion(randomList4,type);
            setResults();
        } else{
            // if none of the radio buttons for order are selected, prompts user to do so
            txtOriginal.setText("");
            txtSorted.setText("");
            txtResults.setText("");
            JOptionPane.showMessageDialog(null, "Make sure to select an amount and sort order.");
        }
        } catch (Exception e){
            txtOriginal.setText("");
            txtSorted.setText("");
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            txtResults.setText("");
            JOptionPane.showMessageDialog(null, "Please enter a valid whole number amount. Make sure to select a sort method and order.");
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
            java.util.logging.Logger.getLogger(SortingEfficiencies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortingEfficiencies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortingEfficiencies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortingEfficiencies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingEfficiencies().setVisible(true);
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
    private javax.swing.JRadioButton fivethousand;
    private javax.swing.JRadioButton hundred;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton ten;
    private javax.swing.JRadioButton thousand;
    private javax.swing.JTextArea txtOriginal;
    private javax.swing.JTextArea txtResults;
    private javax.swing.JTextArea txtSorted;
    // End of variables declaration//GEN-END:variables
}
