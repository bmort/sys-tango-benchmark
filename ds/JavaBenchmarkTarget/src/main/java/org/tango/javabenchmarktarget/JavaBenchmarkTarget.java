/*----- PROTECTED REGION ID(JavaBenchmarkTarget.java) ENABLED START -----*/
//=============================================================================
//
// file :        JavaBenchmarkTarget.java
//
// description : Java source for the JavaBenchmarkTarget class and its commands.
//               The class is derived from Device. It represents the
//               CORBA servant object which will be accessed from the
//               network. All commands which can be executed on the
//               JavaBenchmarkTarget are implemented in this file.
//
// project :     Benchmark device
//
// This file is part of Tango device class.
//
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
//
//
//
//=============================================================================
//                This file is generated by POGO
//        (Program Obviously used to Generate tango Object)
//=============================================================================

/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.java

package org.tango.javabenchmarktarget;

/*----- PROTECTED REGION ID(JavaBenchmarkTarget.imports) ENABLED START -----*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.tango.DeviceState;
import org.tango.server.InvocationContext;
import org.tango.server.ServerManager;
import org.tango.server.annotation.AroundInvoke;
import org.tango.server.annotation.Attribute;
import org.tango.server.annotation.AttributeProperties;
import org.tango.server.annotation.ClassProperty;
import org.tango.server.annotation.Command;
import org.tango.server.annotation.Delete;
import org.tango.server.annotation.Device;
import org.tango.server.annotation.DeviceProperty;
import org.tango.server.annotation.DynamicManagement;
import org.tango.server.annotation.Init;
import org.tango.server.annotation.State;
import org.tango.server.annotation.StateMachine;
import org.tango.server.annotation.Status;
import org.tango.server.annotation.DeviceManagement;
import org.tango.server.annotation.Pipe;
import org.tango.server.attribute.ForwardedAttribute;import org.tango.server.pipe.PipeValue;
import org.tango.server.dynamic.DynamicManager;
import org.tango.server.device.DeviceManager;
import org.tango.server.dynamic.DynamicManager;
import org.tango.server.events.EventManager;
import org.tango.server.events.EventType;
import org.tango.utils.DevFailedUtils;
import org.tango.server.attribute.AttributeValue;
import java.lang.Thread;

//	Import Tango IDL types
import fr.esrf.Tango.*;
import fr.esrf.TangoDs.Except;
import fr.esrf.TangoApi.PipeBlob;
import fr.esrf.TangoApi.PipeDataElement;

import java.lang.System;

import org.tango.javabenchmarktarget.EventThread;

/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.imports

/**
 *  JavaBenchmarkTarget class description:
 *    Benchmark device for counting attribute, command and pipe calls
 */

@Device
public class JavaBenchmarkTarget {

	protected static final Logger logger = LoggerFactory.getLogger(JavaBenchmarkTarget.class);
	protected static final XLogger xlogger = XLoggerFactory.getXLogger(JavaBenchmarkTarget.class);
	//========================================================
	//	Programmer's data members
	//========================================================
    /*----- PROTECTED REGION ID(JavaBenchmarkTarget.variables) ENABLED START -----*/

    //	Put static variables here

    /*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.variables
	/*----- PROTECTED REGION ID(JavaBenchmarkTarget.private) ENABLED START -----*/

	//	Put private variables here
    private long resetTime = 0;
    private EventThread eventThread;
        // self.__benchmark_pipe = (
        //     'PipeBlob',
        //     (
        //         {'name': 'DevLong64', 'value': 123, },
        //         {'name': 'DevULong', 'value': np.uint32(123)},
        //         {'name': 'DevVarUShortArray',
        //          'value': range(5), 'dtype': ('uint16',)},
        //         {'name': 'DevVarDoubleArray',
        //          'value': [1.11, 2.22], 'dtype': ('float64',)},
        //         {'name': 'DevBoolean', 'value': True},
        //     )
        // )

	/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.private

	//========================================================
	//	Property data members and related methods
	//========================================================


	//========================================================
	//	Miscellaneous methods
	//========================================================
	/**
	 * Initialize the device.
	 * 
	 * @throws DevFailed if something fails during the device initialization.
	 */
	@Init(lazyLoading = false)
	public void initDevice() throws DevFailed {
		xlogger.entry();
		logger.debug("init device " + deviceManager.getName());
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.initDevice) ENABLED START -----*/

		//	Put your device initialization code here
		resetTime = System.nanoTime();

		PipeBlob myPipeBlob = new PipeBlob("A");
		myPipeBlob.add(new PipeDataElement("C", "B"));
		benchmarkPipe = new PipeValue(myPipeBlob);
		state = DevState.ON;
		eventSleepPeriod = 10.0;
		eventsAttribute = "BenchmarkScalarAttribute";
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.initDevice
		xlogger.exit();
	}

	/**
	 * all resources may be closed here. Collections may be also cleared.
	 * 
	 * @throws DevFailed if something fails during the device object deletion.
	 */
	@Delete
	public void deleteDevice() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.deleteDevice) ENABLED START -----*/

		//	Put your device clearing code here

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.deleteDevice
		xlogger.exit();
	}

	/**
	 * Method called before and after command and attribute calls.
	 * @param ctx the invocation context
	 * @throws DevFailed if something fails during this method execution.
	 */
	@AroundInvoke
	public void aroundInvoke(final InvocationContext ctx) throws DevFailed {
		xlogger.entry();
			/*----- PROTECTED REGION ID(JavaBenchmarkTarget.aroundInvoke) ENABLED START -----*/

			//	Put aroundInvoke code here
			/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.aroundInvoke
		xlogger.exit();
	}

	
	/**
	 * dynamic command and attribute management. Will be injected by the framework.
	 */
	@DynamicManagement
	protected DynamicManager dynamicManager;
	/**
	 * @param dynamicManager the DynamicManager instance 
	 * @throws DevFailed if something fails during this method execution.
	 */
	public void setDynamicManager(final DynamicManager dynamicManager) throws DevFailed {
		this.dynamicManager = dynamicManager;
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setDynamicManager) ENABLED START -----*/

		//	Put your code here

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setDynamicManager
	}
	
	/**
	 * Device management. Will be injected by the framework.
	 */
	@DeviceManagement
	DeviceManager deviceManager;
	public void setDeviceManager(DeviceManager deviceManager){
		this.deviceManager= deviceManager ;
	}


	//========================================================
	//	Attribute data members and related methods
	//========================================================
	/**
	 * Attribute BenchmarkScalarAttribute, double, Scalar, READ_WRITE
	 * description:
	 *     benchmark scalar attribute
	 */
	@Attribute(name="BenchmarkScalarAttribute", pushChangeEvent=true, checkChangeEvent=false)
	@AttributeProperties(description="benchmark scalar attribute")
	private double benchmarkScalarAttribute;
	/**
	 * Read attribute BenchmarkScalarAttribute
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getBenchmarkScalarAttribute() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getBenchmarkScalarAttribute) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		scalarReadsCount++;
		readAttributeHardwareCount++;
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getBenchmarkScalarAttribute
		attributeValue.setValue(benchmarkScalarAttribute);
		xlogger.exit();
		return attributeValue;
	}
	/**
	 * Write attribute BenchmarkScalarAttribute
	 * @param  benchmarkScalarAttribute value to write
	 * @throws DevFailed if write attribute failed.
	 */
	public void setBenchmarkScalarAttribute(double benchmarkScalarAttribute) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setBenchmarkScalarAttribute) ENABLED START -----*/
		this.benchmarkScalarAttribute = benchmarkScalarAttribute;
		alwaysExecutedHookCount++;
		scalarWritesCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setBenchmarkScalarAttribute
		xlogger.exit();
	}
	
	/**
	 * Attribute AlwaysExecutedHookCount, int, Scalar, READ
	 * description:
	 *     always executed hook count
	 */
	@Attribute(name="AlwaysExecutedHookCount")
	@AttributeProperties(description="always executed hook count")
	private int alwaysExecutedHookCount;
	/**
	 * Read attribute AlwaysExecutedHookCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getAlwaysExecutedHookCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getAlwaysExecutedHookCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getAlwaysExecutedHookCount
		attributeValue.setValue(alwaysExecutedHookCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute ReadAttributeHardwareCount, int, Scalar, READ
	 * description:
	 *     read attribute hardware count
	 */
	@Attribute(name="ReadAttributeHardwareCount")
	@AttributeProperties(description="read attribute hardware count")
	private int readAttributeHardwareCount;
	/**
	 * Read attribute ReadAttributeHardwareCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getReadAttributeHardwareCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getReadAttributeHardwareCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getReadAttributeHardwareCount
		attributeValue.setValue(readAttributeHardwareCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute WriteAttributeCounterCount, int, Scalar, READ
	 * description:
	 *     write attribute counter count
	 */
	@Attribute(name="WriteAttributeCounterCount")
	@AttributeProperties(description="write attribute counter count")
	private int writeAttributeCounterCount;
	/**
	 * Read attribute WriteAttributeCounterCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getWriteAttributeCounterCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getWriteAttributeCounterCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;
		writeAttributeCounterCount = scalarWritesCount +
		    spectrumWritesCount + imageWritesCount;
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getWriteAttributeCounterCount
		attributeValue.setValue(writeAttributeCounterCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute ScalarReadsCount, int, Scalar, READ
	 * description:
	 *     scalar reads count
	 */
	@Attribute(name="ScalarReadsCount")
	@AttributeProperties(description="scalar reads count")
	private int scalarReadsCount;
	/**
	 * Read attribute ScalarReadsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getScalarReadsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getScalarReadsCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getScalarReadsCount
		attributeValue.setValue(scalarReadsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute SpectrumReadsCount, int, Scalar, READ
	 * description:
	 *     spectrum reads count
	 */
	@Attribute(name="SpectrumReadsCount")
	@AttributeProperties(description="spectrum reads count")
	private int spectrumReadsCount;
	/**
	 * Read attribute SpectrumReadsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getSpectrumReadsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getSpectrumReadsCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getSpectrumReadsCount
		attributeValue.setValue(spectrumReadsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute ImageReadsCount, int, Scalar, READ
	 * description:
	 *     image reads count
	 */
	@Attribute(name="ImageReadsCount")
	@AttributeProperties(description="image reads count")
	private int imageReadsCount;
	/**
	 * Read attribute ImageReadsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getImageReadsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getImageReadsCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getImageReadsCount
		attributeValue.setValue(imageReadsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute ScalarWritesCount, int, Scalar, READ
	 * description:
	 *     scalar writes count
	 */
	@Attribute(name="ScalarWritesCount")
	@AttributeProperties(description="scalar writes count")
	private int scalarWritesCount;
	/**
	 * Read attribute ScalarWritesCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getScalarWritesCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getScalarWritesCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getScalarWritesCount
		attributeValue.setValue(scalarWritesCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute SpectrumWritesCount, int, Scalar, READ
	 * description:
	 *     spectrum writes count
	 */
	@Attribute(name="SpectrumWritesCount")
	@AttributeProperties(description="spectrum writes count")
	private int spectrumWritesCount;
	/**
	 * Read attribute SpectrumWritesCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getSpectrumWritesCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getSpectrumWritesCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getSpectrumWritesCount
		attributeValue.setValue(spectrumWritesCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute ImageWritesCount, int, Scalar, READ
	 * description:
	 *     image writes count
	 */
	@Attribute(name="ImageWritesCount")
	@AttributeProperties(description="image writes count")
	private int imageWritesCount;
	/**
	 * Read attribute ImageWritesCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getImageWritesCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getImageWritesCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getImageWritesCount
		attributeValue.setValue(imageWritesCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute CommandCallsCount, int, Scalar, READ
	 * description:
	 *     command calls count
	 */
	@Attribute(name="CommandCallsCount")
	@AttributeProperties(description="command calls count")
	private int commandCallsCount;
	/**
	 * Read attribute CommandCallsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getCommandCallsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getCommandCallsCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getCommandCallsCount
		attributeValue.setValue(commandCallsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute TimeSinceReset, double, Scalar, READ
	 * description:
	 *     time since reset
	 */
	@Attribute(name="TimeSinceReset")
	@AttributeProperties(description="time since reset", label="time since reset",
	                     unit="s")
	private double timeSinceReset;
	/**
	 * Read attribute TimeSinceReset
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getTimeSinceReset() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getTimeSinceReset) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;
		long endTime = System.nanoTime();
		timeSinceReset = (double)(endTime - resetTime) / 1000000000.;
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getTimeSinceReset
		attributeValue.setValue(timeSinceReset);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute PipeReadsCount, int, Scalar, READ
	 * description:
	 *     pipe reads count
	 */
	@Attribute(name="PipeReadsCount")
	@AttributeProperties(description="pipe reads count")
	private int pipeReadsCount;
	/**
	 * Read attribute PipeReadsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getPipeReadsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getPipeReadsCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getPipeReadsCount
		attributeValue.setValue(pipeReadsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute PipeWritesCount, int, Scalar, READ
	 * description:
	 *     pipe writes count
	 */
	@Attribute(name="PipeWritesCount")
	@AttributeProperties(description="pipe writes count")
	private int pipeWritesCount;
	/**
	 * Read attribute PipeWritesCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getPipeWritesCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getPipeWritesCount) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getPipeWritesCount
		attributeValue.setValue(pipeWritesCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute EventSleepPeriod, double, Scalar, READ_WRITE
	 * description:
	 *     sleep period of the event thread in milliseconds
	 */
	@Attribute(name="EventSleepPeriod")
	@AttributeProperties(description="sleep period of the event thread in milliseconds",
	                     unit="ms")
	private double eventSleepPeriod;
	/**
	 * Read attribute EventSleepPeriod
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getEventSleepPeriod() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getEventSleepPeriod) ENABLED START -----*/

		//	Put read attribute code here

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getEventSleepPeriod
		attributeValue.setValue(eventSleepPeriod);
		xlogger.exit();
		return attributeValue;
	}
	/**
	 * Write attribute EventSleepPeriod
	 * @param  eventSleepPeriod value to write
	 * @throws DevFailed if write attribute failed.
	 */
	public void setEventSleepPeriod(double eventSleepPeriod) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setEventSleepPeriod) ENABLED START -----*/
		this.eventSleepPeriod = eventSleepPeriod;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setEventSleepPeriod
		xlogger.exit();
	}
	
	/**
	 * Attribute EventsCount, int, Scalar, READ
	 * description:
	 *     events count
	 */
	@Attribute(name="EventsCount")
	@AttributeProperties(description="events count")
	private int eventsCount;
	/**
	 * Read attribute EventsCount
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getEventsCount() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getEventsCount) ENABLED START -----*/

		//	Put read attribute code here

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getEventsCount
		attributeValue.setValue(eventsCount);
		xlogger.exit();
		return attributeValue;
	}
	
	/**
	 * Attribute EventsAttribute, String, Scalar, READ_WRITE
	 * description:
	 *     Attribute passed in events
	 */
	@Attribute(name="EventsAttribute")
	@AttributeProperties(description="Attribute passed in events", label="events attribute")
	private String eventsAttribute = "";
	/**
	 * Read attribute EventsAttribute
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getEventsAttribute() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getEventsAttribute) ENABLED START -----*/
		
		//	Put read attribute code here
		
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getEventsAttribute
		attributeValue.setValue(eventsAttribute);
		xlogger.exit();
		return attributeValue;
	}
	/**
	 * Write attribute EventsAttribute
	 * @param  eventsAttribute value to write
	 * @throws DevFailed if write attribute failed.
	 */
	public void setEventsAttribute(String eventsAttribute) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setEventsAttribute) ENABLED START -----*/
		this.eventsAttribute = eventsAttribute;
		
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setEventsAttribute
		xlogger.exit();
	}
	
	/**
	 * Attribute BenchmarkSpectrumAttribute, double, Spectrum, READ_WRITE
	 * description:
	 *     benchmark spectrum attribute
	 */
	@Attribute(name="BenchmarkSpectrumAttribute", pushChangeEvent=true, checkChangeEvent=false)
	@AttributeProperties(description="benchmark spectrum attribute")
	private double[] benchmarkSpectrumAttribute = new double[4096];
	/**
	 * Read attribute BenchmarkSpectrumAttribute
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getBenchmarkSpectrumAttribute() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getBenchmarkSpectrumAttribute) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		spectrumReadsCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getBenchmarkSpectrumAttribute
		attributeValue.setValue(benchmarkSpectrumAttribute);
		xlogger.exit();
		return attributeValue;
	}
	/**
	 * Write attribute BenchmarkSpectrumAttribute
	 * @param  benchmarkSpectrumAttribute value to write
	 * @throws DevFailed if write attribute failed.
	 */
	public void setBenchmarkSpectrumAttribute(double[] benchmarkSpectrumAttribute) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setBenchmarkSpectrumAttribute) ENABLED START -----*/
		this.benchmarkSpectrumAttribute = benchmarkSpectrumAttribute;
		alwaysExecutedHookCount++;
		spectrumWritesCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setBenchmarkSpectrumAttribute
		xlogger.exit();
	}
	
	/**
	 * Attribute BenchmarkImageAttribute, double, Image, READ_WRITE
	 * description:
	 *     benchmark image attribute
	 */
	@Attribute(name="BenchmarkImageAttribute", pushChangeEvent=true, checkChangeEvent=false)
	@AttributeProperties(description="benchmark image attribute")
	private double[][] benchmarkImageAttribute = new double[512][256];
	/**
	 * Read attribute BenchmarkImageAttribute
	 * 
	 * @return attribute value
	 * @throws DevFailed if read attribute failed.
	 */
	public org.tango.server.attribute.AttributeValue getBenchmarkImageAttribute() throws DevFailed {
		xlogger.entry();
		org.tango.server.attribute.AttributeValue
			attributeValue = new org.tango.server.attribute.AttributeValue();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getBenchmarkImageAttribute) ENABLED START -----*/

		//	Put read attribute code here
		alwaysExecutedHookCount++;
		imageReadsCount++;
		readAttributeHardwareCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getBenchmarkImageAttribute
		attributeValue.setValue(benchmarkImageAttribute);
		xlogger.exit();
		return attributeValue;
	}
	/**
	 * Write attribute BenchmarkImageAttribute
	 * @param  benchmarkImageAttribute value to write
	 * @throws DevFailed if write attribute failed.
	 */
	public void setBenchmarkImageAttribute(double[][] benchmarkImageAttribute) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setBenchmarkImageAttribute) ENABLED START -----*/
		this.benchmarkImageAttribute = benchmarkImageAttribute;
		alwaysExecutedHookCount++;
		imageWritesCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setBenchmarkImageAttribute
		xlogger.exit();
	}
	

	//========================================================
	//	Pipe data members and related methods
	//========================================================
	/**
	 * Pipe BenchmarkPipe
	 * description:
	 *     benchmark pipe
	 */
	@Pipe(displayLevel=DispLevel._OPERATOR, label="")
	private PipeValue benchmarkPipe;
	/**
	 * Read Pipe BenchmarkPipe
	 * 
	 * @return attribute value
	 * @throws DevFailed if read pipe failed.
	 */
	public PipeValue getBenchmarkPipe() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getBenchmarkPipe) ENABLED START -----*/

		//	Put read pipe code here
 		pipeReadsCount++;
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getBenchmarkPipe
		xlogger.exit();
		return benchmarkPipe;
	}
	/**
	 * Write Pipe BenchmarkPipe
	 * @param  pipeValue value to write
	 * @throws DevFailed if write pipe failed.
	 */
	public void setBenchmarkPipe(PipeValue pipeValue) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setBenchmarkPipe) ENABLED START -----*/
		this.benchmarkPipe = pipeValue;
		// alwaysExecutedHookCount++;
		pipeWritesCount++;

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setBenchmarkPipe
		xlogger.exit();
	}

	//========================================================
	//	Command data members and related methods
	//========================================================
	/**
	 * The state of the device
	*/
	@State
	private DevState state = DevState.UNKNOWN;
	/**
	 * Execute command "State".
	 * description: This command gets the device state (stored in its 'state' data member) and returns it to the caller.
	 * @return Device state
	 * @throws DevFailed if command execution failed.
	 */
	public final DevState getState() throws DevFailed {
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getState) ENABLED START -----*/

		//	Put state code here
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getState
		return state;
	}
	/**
	 * Set the device state
	 * @param state the new device state
	 */
	public void setState(final DevState state) {
		this.state = state;
	}
	
	/**
	 * The status of the device
	 */
	@Status
	private String status = "Server is starting. The device state is unknown";
	/**
	 * Execute command "Status".
	 * description: This command gets the device status (stored in its 'status' data member) and returns it to the caller.
	 * @return Device status
	 * @throws DevFailed if command execution failed.
	 */
	public final String getStatus() throws DevFailed {
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.getStatus) ENABLED START -----*/

		//	Put status code here
		status = "State is ON";
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.getStatus
		return status;
	}
	/**
	 * Set the device status
	 * @param status the new device status
	 */
	public void setStatus(final String status) {
		this.status = status;
	}
	
	/**
	 * Execute command "BenchmarkCommand".
	 * description: benchmark command
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="BenchmarkCommand", inTypeDesc="", outTypeDesc="")
	public void BenchmarkCommand() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.benchmarkCommand) ENABLED START -----*/

		//	Put command code here
		alwaysExecutedHookCount++;
		commandCallsCount++;
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.benchmarkCommand
		xlogger.exit();
	}
	
	/**
	 * Execute command "SetSpectrumSize".
	 * description: set spectrum size
	 * @param setSpectrumSizeIn spectrum size
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="SetSpectrumSize", inTypeDesc="spectrum size", outTypeDesc="")
	public void SetSpectrumSize(int setSpectrumSizeIn) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setSpectrumSize) ENABLED START -----*/

		//	Put command code here
		// alwaysExecutedHookCount++;
		benchmarkSpectrumAttribute = new double[setSpectrumSizeIn];
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setSpectrumSize
		xlogger.exit();
	}
	
	/**
	 * Execute command "SetImageSize".
	 * description: set image size
	 * @param setImageSizeIn image size
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="SetImageSize", inTypeDesc="image size", outTypeDesc="")
	public void SetImageSize(int[] setImageSizeIn) throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.setImageSize) ENABLED START -----*/

		//	Put command code here
		// alwaysExecutedHookCount++;
		benchmarkImageAttribute = new double[setImageSizeIn[0]][setImageSizeIn[1]];
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.setImageSize
		xlogger.exit();
	}
	
	/**
	 * Execute command "ResetCounters".
	 * description: reset counters
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="ResetCounters", inTypeDesc="", outTypeDesc="")
	public void ResetCounters() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.resetCounters) ENABLED START -----*/

		//	Put command code here
		// alwaysExecutedHookCount++;
		alwaysExecutedHookCount = 0;
		readAttributeHardwareCount = 0;
		writeAttributeCounterCount = 0;

		scalarReadsCount = 0;
		spectrumReadsCount = 0;
		imageReadsCount = 0;
		pipeReadsCount = 0;

		scalarWritesCount = 0;
		spectrumWritesCount = 0;
		imageWritesCount = 0;
		pipeWritesCount = 0;

 		commandCallsCount = 0;
 		eventsCount = 0;
		resetTime = System.nanoTime();

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.resetCounters
		xlogger.exit();
	}
	
	/**
	 * Execute command "StartEvents".
	 * description: starts a thread which pushes events of BenchmarkScalar Attribute values
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="StartEvents", inTypeDesc="", outTypeDesc="")
	@StateMachine(deniedStates={DeviceState.RUNNING})
	public void StartEvents() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.startEvents) ENABLED START -----*/
		eventsCount = 0;
		eventThread = new EventThread(this,
					      (int)eventSleepPeriod);
		eventThread.start();
		state = DevState.RUNNING;
	
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.startEvents
		xlogger.exit();
	}
	
	/**
	 * Execute command "StopEvents".
	 * description: stops a thread which pushes events of BenchmarkScalar Attribute values
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="StopEvents", inTypeDesc="", outTypeDesc="")
	public void StopEvents() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.stopEvents) ENABLED START -----*/
		eventThread.setRunning(false);
		while(!eventThread.getFinished()){
		    try{
			Thread.sleep(10);
                   }
		    catch(java.lang.InterruptedException e){
		    }
		}
		try{
		    eventThread.join();
		}
		catch(java.lang.InterruptedException e){
		}
		state = DevState.ON;
		eventsCount = eventThread.getCounter();
		int errorCounter = eventThread.getErrorCounter();

		
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.stopEvents
		xlogger.exit();
	}
	
	/**
	 * Execute command "PushEvent".
	 * description: pushes an event of BenchmarkScalarAttribute
	 * @throws DevFailed if command execution failed.
	 */
	@Command(name="PushEvent", inTypeDesc="", outTypeDesc="")
	public void PushEvent() throws DevFailed {
		xlogger.entry();
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.pushEvent) ENABLED START -----*/
		
               deviceManager.pushEvent(eventsAttribute,
                                       new AttributeValue(benchmarkScalarAttribute),
                                       EventType.CHANGE_EVENT);
	       
		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.pushEvent
		xlogger.exit();
	}
	

	//========================================================
	//	Programmer's methods
	//========================================================
	/*----- PROTECTED REGION ID(JavaBenchmarkTarget.methods) ENABLED START -----*/

	//	Put your own methods here

	/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.methods


	
	
	
	
	/**
	 * Starts the server.
	 * @param args program arguments (instance_name [-v[trace level]]  [-nodb [-dlist <device name list>] [-file=fileName]])
	 */
	public static void main(final String[] args) {
		/*----- PROTECTED REGION ID(JavaBenchmarkTarget.main) ENABLED START -----*/

		/*----- PROTECTED REGION END -----*/	//	JavaBenchmarkTarget.main
		ServerManager.getInstance().start(args, JavaBenchmarkTarget.class);
		System.out.println("------- Started -------------");
	}
}
