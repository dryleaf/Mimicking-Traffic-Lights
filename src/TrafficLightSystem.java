/**
 * Created by dryleaf on 8/9/16.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLightSystem extends JFrame implements Runnable
{
    private Dimension screenSize;
    private static int light = 25;
    private static int msbDigit;
    private static int lsbDigit;
    private static boolean greenOnOff = false;
    private static boolean orangeOnOff = false;
    private static boolean redOnOff = false;
    private static boolean amsbFlag = false, alsbFlag = false;
    private static boolean bmsbFlag = false, blsbFlag = false;
    private static boolean cmsbFlag = false, clsbFlag = false;
    private static boolean dmsbFlag = false, dlsbFlag = false;
    private static boolean emsbFlag = false, elsbFlag = false;
    private static boolean fmsbFlag = false, flsbFlag = false;
    private static boolean gmsbFlag = false, glsbFlag = false;

    public TrafficLightSystem()
    {
        super( "Traffic Light System" );

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        add( new DisplayLights() );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 400, 700 );
        setResizable( false );
        setLocation( (int)screenSize.getWidth()/2-200, (int)screenSize.getHeight()/2-350 );
        setVisible( true );
    }
    public void run()
    {
        for( light = 25; light >= 0 ; light-- )
        {
            if( light >= 15 )
            {
                redOnOff = true;
                orangeOnOff = false;
                greenOnOff = false;
            }
            else if( light < 15 && light >= 5 )
            {
                redOnOff = false;
                orangeOnOff = false;
                greenOnOff = true;
            }
            else if( light < 5 && light >= 0 )
            {
                redOnOff = false;
                orangeOnOff = true;
                greenOnOff = false;
            }
            msbDigit = light / 10;
            lsbDigit = light % 10;
            if( light == 0 )
                light = 26;

            if( msbDigit == 0 || lsbDigit == 0 )
            {
                if( msbDigit == 0 )
                {
                    amsbFlag = true;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = true;
                    gmsbFlag = false;
                }
                if( lsbDigit == 0 )
                {
                    alsbFlag = true;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = true;
                    glsbFlag = false;
                }
                if( lsbDigit == msbDigit )
                {
                    amsbFlag = bmsbFlag = cmsbFlag = dmsbFlag = emsbFlag = fmsbFlag = false;
                    alsbFlag = blsbFlag = clsbFlag = dlsbFlag = elsbFlag = flsbFlag = false;
                    gmsbFlag = glsbFlag = true;
                }
            }
            if( msbDigit == 1 || lsbDigit == 1 )
            {
                if( msbDigit == 1 )
                {
                    amsbFlag = false;
                    bmsbFlag = false;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = false;
                    fmsbFlag = false;
                    gmsbFlag = false;
                }
                if( lsbDigit == 1 )
                {
                    alsbFlag = false;
                    blsbFlag = false;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = false;
                    flsbFlag = false;
                    glsbFlag = false;
                }
            }
            if( msbDigit == 2 || lsbDigit == 2 )
            {
                if( msbDigit == 2 )
                {
                    amsbFlag = false;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = false;
                    emsbFlag = true;
                    fmsbFlag = true;
                    gmsbFlag = true;
                }
                if( lsbDigit == 2 )
                {
                    alsbFlag = false;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = false;
                    elsbFlag = true;
                    flsbFlag = true;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 3 || lsbDigit == 3 )
            {
                if( msbDigit == 3 )
                {
                    amsbFlag = false;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = false;
                    gmsbFlag = true;
                }
                if( lsbDigit == 3 )
                {
                    alsbFlag = false;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = false;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 4 || lsbDigit == 4 )
            {
                if( msbDigit == 4 )
                {
                    amsbFlag = true;
                    bmsbFlag = false;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = false;
                    fmsbFlag = false;
                    gmsbFlag = true;
                }
                if( lsbDigit == 4 )
                {
                    alsbFlag = true;
                    blsbFlag = false;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = false;
                    flsbFlag = false;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 5 || lsbDigit == 5 )
            {
                if( msbDigit == 5 )
                {
                    amsbFlag = true;
                    bmsbFlag = true;
                    cmsbFlag = false;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = false;
                    gmsbFlag = true;
                }
                if( lsbDigit == 5 )
                {
                    alsbFlag = true;
                    blsbFlag = true;
                    clsbFlag = false;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = false;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 6 || lsbDigit == 6 )
            {
                if( msbDigit == 6 )
                {
                    amsbFlag = true;
                    bmsbFlag = true;
                    cmsbFlag = false;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = true;
                    gmsbFlag = true;
                }
                if( lsbDigit == 6 )
                {
                    alsbFlag = true;
                    blsbFlag = true;
                    clsbFlag = false;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = true;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 7 || lsbDigit == 7 )
            {
                if( msbDigit == 7 )
                {
                    amsbFlag = false;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = false;
                    fmsbFlag = false;
                    gmsbFlag = false;
                }
                if( lsbDigit == 7 )
                {
                    alsbFlag = false;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = false;
                    flsbFlag = false;
                    glsbFlag = false;
                }
            }
            if( msbDigit == 8 || lsbDigit == 8 )
            {
                if( msbDigit == 8 )
                {
                    amsbFlag = true;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = true;
                    gmsbFlag = true;
                }
                if( lsbDigit == 8 )
                {
                    alsbFlag = true;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = true;
                    glsbFlag = true;
                }
            }
            if( msbDigit == 9 || lsbDigit == 9 )
            {
                if( msbDigit == 9 )
                {
                    amsbFlag = true;
                    bmsbFlag = true;
                    cmsbFlag = true;
                    dmsbFlag = true;
                    emsbFlag = true;
                    fmsbFlag = false;
                    gmsbFlag = true;
                }
                if( lsbDigit == 9 )
                {
                    alsbFlag = true;
                    blsbFlag = true;
                    clsbFlag = true;
                    dlsbFlag = true;
                    elsbFlag = true;
                    flsbFlag = false;
                    glsbFlag = true;
                }
            }
            repaint();
            try
            {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException exception )
            {
                exception.printStackTrace();
            }
        }
    }

    private class DisplayLights extends JPanel
    {
        public void paintComponent( Graphics g )
        {
            Graphics2D g2D = ( Graphics2D ) g;

            g2D.setColor( Color.ORANGE );
            g2D.fill( new Rectangle2D.Double( 120, 20, 160, 80 ) );
            g2D.setColor( Color.BLACK );
            g2D.fill( new Rectangle2D.Double( 125, 25, 150, 70 ) );

            // display in LCD 88
            // MSB DIGIT
            if( amsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] axmsbPoints = { 150, 155, 160, 160, 155, 150, 150 };
            int[] aymsbPoints = { 40, 35, 40, 55, 60, 55, 40 };
            g2D.fill( new Polygon( axmsbPoints, aymsbPoints, 7 ) );

            if( bmsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] bxmsbPoints = { 163, 158, 163, 178, 183, 178, 163 };
            int[] bymsbPoints = { 40, 35, 30, 30, 35, 40, 40 };
            g2D.fill( new Polygon( bxmsbPoints, bymsbPoints, 7 ) );

            if( cmsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] cxmsbPoints = { 181, 186, 191, 191, 186, 181, 181 };
            int[] cymsbPoints = { 40, 35, 40, 55, 60, 55, 40 };
            g2D.fill( new Polygon( cxmsbPoints, cymsbPoints, 7 ) );

            if( dmsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] dxmsbPoints = { 181, 186, 191, 191, 186, 181, 181 };
            int[] dymsbPoints = { 68, 63, 68, 83, 88, 83, 68 };
            g2D.fill( new Polygon( dxmsbPoints, dymsbPoints, 7 ) );

            if( emsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] exmsbPoints = { 163, 158, 163, 178, 183, 178, 163 };
            int[] eymsbPoints = { 93, 88, 83, 83, 88, 93, 93 };
            g2D.fill( new Polygon( exmsbPoints, eymsbPoints, 7 ) );

            if( fmsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] fxmsbPoints = { 150, 155, 160, 160, 155, 150, 150 };
            int[] fymsbPoints = { 68, 63, 68, 83, 88, 83, 68 };
            g2D.fill( new Polygon( fxmsbPoints, fymsbPoints, 7 ) );

            if( gmsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] gxmsbPoints = { 163, 158, 163, 178, 183, 178, 163 };
            int[] gymsbPoints = { 67, 62, 57, 57, 62, 67, 67 };
            g2D.fill( new Polygon( gxmsbPoints, gymsbPoints, 7 ) );

            // LSB DIGIT
            if( alsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] axlsbPoints = { 210, 215, 220, 220, 215, 210, 210 };
            int[] aylsbPoints = { 40, 35, 40, 55, 60, 55, 40 };
            g2D.fill( new Polygon( axlsbPoints, aylsbPoints, 7 ) );

            if( blsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] bxlsbPoints = { 223, 218, 223, 238, 243, 238, 223 };
            int[] bylsbPoints = { 40, 35, 30, 30, 35, 40, 40 };
            g2D.fill( new Polygon( bxlsbPoints, bylsbPoints, 7 ) );

            if( clsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] cxlsbPoints = { 241, 246, 251, 251, 246, 241, 241 };
            int[] cylsbPoints = { 40, 35, 40, 55, 60, 55, 40 };
            g2D.fill( new Polygon( cxlsbPoints, cylsbPoints, 7 ) );

            if( dlsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] dxlsbPoints = { 241, 246, 251, 251, 246, 241, 241 };
            int[] dylsbPoints = { 68, 63, 68, 83, 88, 83, 68 };
            g2D.fill( new Polygon( dxlsbPoints, dylsbPoints, 7 ) );

            if( elsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] exlsbPoints = { 223, 218, 223, 238, 243, 238, 223 };
            int[] eylsbPoints = { 93, 88, 83, 83, 88, 93, 93 };
            g2D.fill( new Polygon( exlsbPoints, eylsbPoints, 7 ) );

            if( flsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] fxlsbPoints = { 210, 215, 220, 220, 215, 210, 210 };
            int[] fylsbPoints = { 68, 63, 68, 83, 88, 83, 68 };
            g2D.fill( new Polygon( fxlsbPoints, fylsbPoints, 7 ) );

            if( glsbFlag )
                g2D.setColor( Color.RED );
            else
                g2D.setColor( Color.BLACK );
            int[] gxlsbPoints = { 223, 218, 223, 238, 243, 238, 223 };
            int[] gylsbPoints = { 67, 62, 57, 57, 62, 67, 67 };
            g2D.fill( new Polygon( gxlsbPoints, gylsbPoints, 7 ) );

            // LIGHT SIGNAL
            g2D.setColor( Color.ORANGE );
            g2D.fill( new Rectangle2D.Double( 120, 110, 160, 360 ) );
            g2D.setColor( Color.BLACK );
            g2D.fill( new Rectangle2D.Double( 125, 115, 150, 350 ) );

            g2D.setColor( Color.ORANGE );
            int[] xPoints = { 180, 180, 220, 220 };
            int[] yPoints = { 470, 650, 650, 470 };
            g2D.fill( new Polygon( xPoints, yPoints, 4 ) );

            g2D.setColor( Color.RED );
            if( redOnOff )
                g2D.fill( new Ellipse2D.Double( 160, 150, 80, 80 ) );
            else
                g2D.draw( new Ellipse2D.Double( 160, 150, 80, 80 ) );

            g2D.setColor( Color.ORANGE );
            if( orangeOnOff )
                g2D.fill( new Ellipse2D.Double( 160, 250, 80, 80 ) );
            else
                g2D.draw( new Ellipse2D.Double( 160, 250, 80, 80 ) );

            g2D.setColor( Color.GREEN );
            if( greenOnOff )
                g2D.fill( new Ellipse2D.Double( 160, 350, 80, 80 ) );
            else
                g2D.draw( new Ellipse2D.Double( 160, 350, 80, 80 ) );
        }
    }

    public static void main( String[] args )
    {
        new Thread( new TrafficLightSystem() ).start();
    }
}