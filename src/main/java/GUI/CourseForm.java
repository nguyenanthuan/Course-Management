package GUI;

import BLL.CourseBLL;
import BLL.DepartmentBLL;
import BLL.OnlineCourseBLL;
import BLL.OnsiteCourseBLL;
import DTO.Course;
import DTO.Department;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class CourseForm extends javax.swing.JFrame {
    
    CourseBLL cou = new CourseBLL();
    OnlineCourseBLL olcBll = new OnlineCourseBLL();
    OnsiteCourseBLL oscBll = new OnsiteCourseBLL();
    DepartmentBLL dpmBLL = new DepartmentBLL();
    List lstcou;
    List LastList;
    ArrayList<JPanel> checkBoxPanels;
    /**
     * Creates new form CourseForm
     */
    public CourseForm() {
        initComponents();
        textFieldChange();
        jpnOnline.setVisible(false);
        jpnOnsite.setVisible(false);
        try {
            LastList = lstcou = cou.LoadCourses(1);
            listCourse(lstcou);
            generateDays();
            loadCb();
        } catch (SQLException ex) {
            Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    private void generateDays() {
        String [] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        jpnDays.setLayout(new BoxLayout(jpnDays, BoxLayout.X_AXIS));
        checkBoxPanels = new ArrayList<>();
        for (String day : daysOfWeek) {
            JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JCheckBox checkBox = new JCheckBox(day);
            checkBoxPanel.add(checkBox);
            checkBoxPanels.add(checkBoxPanel);
            jpnDays.add(checkBoxPanel);
        }
    }
    
    private void loadCb() throws SQLException {
        List ChuyenMonKH = dpmBLL.LoadDepartment(1);
        if(!ChuyenMonKH.isEmpty()) {
            Department temp = new Department();
            temp.setName("All");
            jcbDepartment.addItem(temp);
            for(int i = 0; i < ChuyenMonKH.size(); i++) {
                Department dpm = (Department) ChuyenMonKH.get(i);
                jcbDepartment.addItem(dpm);
            }
        }
        else {
            Department dpm = new Department();
            dpm.setName("No data");
            jcbDepartment.setEnabled(false);
        }
        
    }
    
    
    
    public void listCourse(List list) throws SQLException {
        DefaultTableModel model = convertCourse(list);

        jtbCourse.setModel(model);
        jtbCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!jtbCourse.contains(e.getPoint())) {
                    jtbCourse.clearSelection();
                }
            }
        });
        jlbNumOfRow.setText("Num of rows: " + list.size());
    }
    
    private DefaultTableModel convertCourse(List list) {
        String[] columnNames = {"No.", "CourseID", "Name", "Credits", 
            "Department", "Online/Onsite"};
        Object[][] data = new Object[list.size()][6];
        OnlineCourse olc = new OnlineCourse();
        OnsiteCourse osc = new OnsiteCourse();
        Department dpm = new Department();
        for (int i = 0; i < list.size(); i++) {
            Course c = (Course) list.get(i);
            data[i][0] = i + 1; 
            data[i][1] = c.getCourseId();
            data[i][2] = c.getTitle();
            data[i][3] = c.getCredits();
            
            try {
                dpm = dpmBLL.getDepartment(c.getDepartmentId());
                olc = olcBll.getOnlineCourse(c.getCourseId());
                if (olc == null) {
                    osc = oscBll.getOnsiteCourse(c.getCourseId());
                }   
            } catch (SQLException ex) {
                Logger.getLogger(KhoaHocJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(dpm != null) {
                data[i][4] = dpm.getName();
            }
            else {
                data[i][4] = "None of Department!";
            }
            if(olc != null) {
                data[i][5] = "Online";
            }
            else if(osc != null) {
                data[i][5] = "Onsite";
            }
            else {
                data[i][5] = "Khóa học chưa có thông tin";
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnEast = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jbtnThem = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jpnNouth = new javax.swing.JPanel();
        jpnSearch = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbDepartment = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcbOnlineOnsite = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jlbNumOfRow = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCourse = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtfTitle = new javax.swing.JTextField();
        jpnOnsite = new javax.swing.JPanel();
        jpnDays = new javax.swing.JPanel();
        jpnLocation2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spnHour = new javax.swing.JSpinner();
        spnMinute = new javax.swing.JSpinner();
        jpnLocation1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtfLocation = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jpnOnline = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jtfURL = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnEast.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnEast.setPreferredSize(new java.awt.Dimension(120, 353));

        jbtnThem.setText("Add");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnXoa.setText("Delete");
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jbtnSua.setText("Edit");
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jbtnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnThem)
                .addGap(18, 18, 18)
                .addComponent(jbtnXoa)
                .addGap(18, 18, 18)
                .addComponent(jbtnSua)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnEastLayout = new javax.swing.GroupLayout(jpnEast);
        jpnEast.setLayout(jpnEastLayout);
        jpnEastLayout.setHorizontalGroup(
            jpnEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnEastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnEastLayout.setVerticalGroup(
            jpnEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnEastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(jpnEast, java.awt.BorderLayout.LINE_END);

        jpnNouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Department:");

        jcbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Online/Onsite:");

        jcbOnlineOnsite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Online", "Onsite" }));
        jcbOnlineOnsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOnlineOnsiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOnlineOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbOnlineOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Search:");

        jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimKiemActionPerformed(evt);
            }
        });
        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnSearchLayout = new javax.swing.GroupLayout(jpnSearch);
        jpnSearch.setLayout(jpnSearchLayout);
        jpnSearchLayout.setHorizontalGroup(
            jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnSearchLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jpnSearchLayout.setVerticalGroup(
            jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnNouthLayout = new javax.swing.GroupLayout(jpnNouth);
        jpnNouth.setLayout(jpnNouthLayout);
        jpnNouthLayout.setHorizontalGroup(
            jpnNouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNouthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jpnNouthLayout.setVerticalGroup(
            jpnNouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNouthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jpnNouth, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbNumOfRow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNumOfRow, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(909, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNumOfRow, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtbCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCourse);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Title:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnDaysLayout = new javax.swing.GroupLayout(jpnDays);
        jpnDays.setLayout(jpnDaysLayout);
        jpnDaysLayout.setHorizontalGroup(
            jpnDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        jpnDaysLayout.setVerticalGroup(
            jpnDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Time:");

        spnHour.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(1L), Long.valueOf(0L), Long.valueOf(23L), Long.valueOf(1L)));

        spnMinute.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        javax.swing.GroupLayout jpnLocation2Layout = new javax.swing.GroupLayout(jpnLocation2);
        jpnLocation2.setLayout(jpnLocation2Layout);
        jpnLocation2Layout.setHorizontalGroup(
            jpnLocation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLocation2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spnMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnLocation2Layout.setVerticalGroup(
            jpnLocation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLocation2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLocation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spnHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Location:");

        javax.swing.GroupLayout jpnLocation1Layout = new javax.swing.GroupLayout(jpnLocation1);
        jpnLocation1.setLayout(jpnLocation1Layout);
        jpnLocation1Layout.setHorizontalGroup(
            jpnLocation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLocation1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(61, 61, 61)
                .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLocation1Layout.setVerticalGroup(
            jpnLocation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLocation1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLocation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Days:");

        javax.swing.GroupLayout jpnOnsiteLayout = new javax.swing.GroupLayout(jpnOnsite);
        jpnOnsite.setLayout(jpnOnsiteLayout);
        jpnOnsiteLayout.setHorizontalGroup(
            jpnOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOnsiteLayout.createSequentialGroup()
                .addGroup(jpnOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnLocation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLocation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpnOnsiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jpnOnsiteLayout.setVerticalGroup(
            jpnOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOnsiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnLocation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnLocation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOnsiteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jpnOnsiteLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("URL:");

        javax.swing.GroupLayout jpnOnlineLayout = new javax.swing.GroupLayout(jpnOnline);
        jpnOnline.setLayout(jpnOnlineLayout);
        jpnOnlineLayout.setHorizontalGroup(
            jpnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOnlineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfURL, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnOnlineLayout.setVerticalGroup(
            jpnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOnlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtfURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpnOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        AddNewCourse1 addfrm = new AddNewCourse1(this);
        addfrm.setSize(700, 300);
        addfrm.setVisible(true);
        
        
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jcbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartmentActionPerformed
        try {
            searchTool();
        } catch (SQLException ex) {
            Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbDepartmentActionPerformed
    
    private void textFieldChange() {
        jtfTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textChanged();
            }

            private void textChanged() {
                try {
                    searchTool();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void searchTool() throws SQLException {
        boolean check = true;
        LastList = new ArrayList();
        for(int i = 0; i < lstcou.size(); i++) {
                Course cour = (Course) lstcou.get(i);
            if (jcbDepartment.getSelectedIndex() != 0) {
                Department dpm = (Department)jcbDepartment.getSelectedItem();
                if(dpm.getDepartmentID() != cour.getDepartmentId()) {
                     check = false;
                }  
            }
            if (jcbOnlineOnsite.getSelectedIndex() != 0) {
                OnlineCourse olc = olcBll.getOnlineCourse(cour.getCourseId());
                String tscour;
                if(olc != null) {
                    tscour = "Online";
                }
                else {
                     tscour = "Onsite";
                }
                String find = (String) jcbOnlineOnsite.getSelectedItem();
                if(!tscour.equals(find)) {
                    check = false;
                }
            }
            String tf = jtfTimKiem.getText();
            if(!tf.isEmpty()) {
                String namec = cour.getTitle().toLowerCase();
                if(!namec.contains(tf.toLowerCase())) {
                    check = false;
                }
            }
            if(check) {
                LastList.add(cour);
            }
            check = true;
        }
            listCourse(LastList);
    }
    
    private void jcbOnlineOnsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOnlineOnsiteActionPerformed
        try {
            searchTool();
        } catch (SQLException ex) {
            Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbOnlineOnsiteActionPerformed

    
    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void jtfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimKiemKeyPressed

    private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimKiemActionPerformed
        
    }//GEN-LAST:event_jtfTimKiemActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        int[] selectedRows = jtbCourse.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int id = Integer.parseInt(String.valueOf(jtbCourse.getValueAt( selectedRows[i], 1)));
                String olos = String.valueOf(jtbCourse.getValueAt( selectedRows[i], 5));
                JOptionPane.showMessageDialog(this, selectedRows[i]);
                try {             
                    if(olos == "Online") {
                        if(olcBll.removeCourse(id) > 0 && cou.removeCourse(id) > 0) {
                            JOptionPane.showMessageDialog(this, "Xóa khóa online thành công!");
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Xóa khóa online thất bại!");
                        }
                        
                    }
                    else if(olos == "Onsite") {
                        if(oscBll.removeCourse(id) > 0 && cou.removeCourse(id) > 0) {
                            JOptionPane.showMessageDialog(this, "Xóa khóa onsite thành công!");
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Xóa khóa onsite thất bại!");
                        }
                    }
                    
                }
                catch (SQLException ex) {
                        Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                LastList = lstcou = cou.LoadCourses(1);
                listCourse(lstcou);
            } catch (SQLException ex) {
                Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
        else {
           JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
        }
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jtbCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCourseMouseClicked
        int selectedRow = jtbCourse.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(jtbCourse.getValueAt( selectedRow, 1)));
        Course c = new Course();
        OnlineCourse olc = new OnlineCourse();
        OnsiteCourse osc = new OnsiteCourse();
        try {
            c = cou.getCourse(id);
            olc = olcBll.getOnlineCourse(id);
            osc = oscBll.getOnsiteCourse(id);
        } catch (SQLException ex) {
            Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtfTitle.setText(c.getTitle());
        if(olc != null) {
            jtfURL.setText(olc.getUrl());
            jpnOnline.setVisible(true);
            jpnOnsite.setVisible(false);
        }
        if(osc != null) {
            jpnOnsite.setVisible(false);
            jtfLocation.setText(osc.getLocation());
            spnHour.setValue(osc.getTime().getHours());
            spnMinute.setValue(osc.getTime().getMinutes());
            String [] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
            jpnDays.setLayout(new BoxLayout(jpnDays, BoxLayout.X_AXIS));
            checkBoxPanels = new ArrayList<>();
            char[] days = osc.getDays().toCharArray();
            jpnDays.removeAll();
            int i = 0;
            for (String day : daysOfWeek) {
                JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JCheckBox checkBox = new JCheckBox(day);
                if(i < days.length) {
                    char t = days[i];
                    if(t == day.charAt(0)) {
                        checkBox.setSelected(true);
                        i++;
                    }
                    if(t == 'H' && day.equals("Thu")) {
                        checkBox.setSelected(true);
                        i++;
                    }
                }

                checkBoxPanel.add(checkBox);
                checkBoxPanels.add(checkBoxPanel);
                jpnDays.add(checkBoxPanel);
            }
            
            
            jpnOnline.setVisible(false);
            jpnOnsite.setVisible(true);
        }
    }//GEN-LAST:event_jtbCourseMouseClicked

    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        int selectedRow = jtbCourse.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(jtbCourse.getValueAt( selectedRow, 1)));
        Course c = new Course();
        OnlineCourse olc = new OnlineCourse();
        OnsiteCourse osc = new OnsiteCourse();
        try {
            c = cou.getCourse(id);
            olc = olcBll.getOnlineCourse(id);
            osc = oscBll.getOnsiteCourse(id);
            String title = jtfTitle.getText();
            c.setTitle(title);
            if(olc != null) {
                String URL = jtfURL.getText();
                olc.setUrl(URL);
                if(olcBll.updateCourse(olc) > 0 && cou.updateCourse(c) > 0 ) {
                    JOptionPane.showConfirmDialog(null, "Sửa khóa học thành công!");
                }
                else {
                    JOptionPane.showConfirmDialog(null, "Sửa khóa học thất bại!", "Lỗi",JOptionPane.WARNING_MESSAGE);
                }
                jpnOnline.setVisible(true);
                jpnOnsite.setVisible(false);
            }
            if(osc != null) {
                String location = jtfLocation.getText();
                Time time = Time.valueOf("00:00:00");
                int hour = (int)spnHour.getValue();
                time.setHours(hour);
                time.setMinutes((int)spnMinute.getValue());
                String Days = "";
                for (JPanel panel : checkBoxPanels) {
                    JCheckBox checkBox = (JCheckBox) panel.getComponent(0);
                    if (checkBox.isSelected()) {
                        if(checkBox.getText() == "Thu") {
                             Days += "H";
                        } 
                        else {
                            Days += checkBox.getText().charAt(0);
                        }
                    }
                }
                osc.setDays(Days);
                osc.setLocation(location);
                osc.setTime(time);
                if(oscBll.updateCourse(osc) > 0 && cou.updateCourse(c) > 0) {
                   JOptionPane.showConfirmDialog(null, "Sửa khóa học thành công!");
                }
                else {
                    JOptionPane.showConfirmDialog(null, "Sửa khóa học thất bại!", "Lỗi",JOptionPane.WARNING_MESSAGE);
                }
            }
            LastList = lstcou = cou.LoadCourses(1);
            listCourse(lstcou);
        }
        catch (SQLException ex) {
            Logger.getLogger(CourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JComboBox<Department> jcbDepartment;
    private javax.swing.JComboBox<String> jcbOnlineOnsite;
    private javax.swing.JLabel jlbNumOfRow;
    private javax.swing.JPanel jpnDays;
    private javax.swing.JPanel jpnEast;
    private javax.swing.JPanel jpnLocation1;
    private javax.swing.JPanel jpnLocation2;
    private javax.swing.JPanel jpnNouth;
    private javax.swing.JPanel jpnOnline;
    private javax.swing.JPanel jpnOnsite;
    private javax.swing.JPanel jpnSearch;
    private javax.swing.JTable jtbCourse;
    private javax.swing.JTextField jtfLocation;
    private javax.swing.JTextField jtfTimKiem;
    private javax.swing.JTextField jtfTitle;
    private javax.swing.JTextField jtfURL;
    private javax.swing.JSpinner spnHour;
    private javax.swing.JSpinner spnMinute;
    // End of variables declaration//GEN-END:variables
}
