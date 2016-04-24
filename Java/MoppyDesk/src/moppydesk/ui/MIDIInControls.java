
package moppydesk.ui;

import moppydesk.inputs.MoppyMIDIInput;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Controls for the {@link MoppyMIDIInput} object.
 * @author Sam
 */
public class MIDIInControls extends InputPanel {

    MoppyMIDIInput midiInput;
    HashMap<String,Info> availableMIDIIns = MoppyMIDIInput.getMIDIInInfos();
    
    /**
     * Creates new form midiInControls
     */
    public MIDIInControls(MoppyMIDIInput midiInput) {
        this.midiInput = midiInput;
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

        midiInComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        midiInComboBox.setModel(new DefaultComboBoxModel(availableMIDIIns.keySet().toArray(new String[0])));
        midiInComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midiInComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("MIDI IN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(midiInComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(midiInComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void midiInComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midiInComboBoxActionPerformed
        try {
            midiInput.setDevice(availableMIDIIns.get(((JComboBox)evt.getSource()).getSelectedItem()));
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MIDIInControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_midiInComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox midiInComboBox;
    // End of variables declaration//GEN-END:variables

    public Transmitter getTransmitter() {
        return midiInput;
    }

    public void connected() {
        //Nothing to do;
    }

    public void disconnected() {
        midiInput.setReceiver(null); // Clear out receiver so that MIDI messages aren't sent anywhere.
    }         
}
