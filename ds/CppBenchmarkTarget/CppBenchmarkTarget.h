/*----- PROTECTED REGION ID(CppBenchmarkTarget.h) ENABLED START -----*/
//=============================================================================
//
// file :        CppBenchmarkTarget.h
//
// description : Include file for the CppBenchmarkTarget class
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


#ifndef CppBenchmarkTarget_H
#define CppBenchmarkTarget_H

#include <tango.h>
#include <sys/time.h>

/*----- PROTECTED REGION END -----*/	//	CppBenchmarkTarget.h

/**
 *  CppBenchmarkTarget class description:
 *    Benchmark device for counting attribute, command and pipe calls
 */

namespace CppBenchmarkTarget_ns
{
/*----- PROTECTED REGION ID(CppBenchmarkTarget::Additional Class Declarations) ENABLED START -----*/

//	Additional Class Declarations
  class EventThread;
/*----- PROTECTED REGION END -----*/	//	CppBenchmarkTarget::Additional Class Declarations

class CppBenchmarkTarget : public TANGO_BASE_CLASS
{

/*----- PROTECTED REGION ID(CppBenchmarkTarget::Data Members) ENABLED START -----*/

//	Add your own data members
  int attr_BenchmarkSpectrumAttribute_length = 4096;
  int attr_BenchmarkImageAttribute_length = 256*512;
  int attr_BenchmarkImageAttribute_x = 256;
  int attr_BenchmarkImageAttribute_y = 512;

  int always_executed_hook_count = 0;
  int read_attribute_hardware_count = 0;
  int write_attribute_counter_count = 0;

  int scalar_reads_count = 0;
  int spectrum_reads_count = 0;
  int image_reads_count = 0;
  int pipe_reads_count = 0;

  int scalar_writes_count = 0;
  int spectrum_writes_count = 0;
  int image_writes_count = 0;
  int pipe_writes_count = 0;

  int command_calls_count = 0;
  int scalar_events_count = 0;

  std::vector<std::string> event_attributes {"BenchmarkScalarAttribute",
      "BenchmarkSpectrumAttribute",
      "BenchmarkImageAttribute"};

  struct timeval reset_time;

  std::string pipe_name = "";
  std::string pipe_blob_name = "BlobCaseEven";
  std::vector<std::string> pipe_element_names {"EvenFirstDE","EvenSecondDE"};
  size_t pipe_size = 2;

  omni_mutex m_mutex;
  EventThread* event_thread = NULL;
  Tango::DevState m_state = Tango::ON; // replace by your own algorithm
  
  
/*----- PROTECTED REGION END -----*/	//	CppBenchmarkTarget::Data Members


//	Attribute data members
public:
	Tango::DevDouble	*attr_BenchmarkScalarAttribute_read;
	Tango::DevLong	*attr_AlwaysExecutedHookCount_read;
	Tango::DevLong	*attr_ReadAttributeHardwareCount_read;
	Tango::DevLong	*attr_WriteAttributeCounterCount_read;
	Tango::DevLong	*attr_ScalarReadsCount_read;
	Tango::DevLong	*attr_SpectrumReadsCount_read;
	Tango::DevLong	*attr_ImageReadsCount_read;
	Tango::DevLong	*attr_ScalarWritesCount_read;
	Tango::DevLong	*attr_SpectrumWritesCount_read;
	Tango::DevLong	*attr_ImageWritesCount_read;
	Tango::DevLong	*attr_CommandCallsCount_read;
	Tango::DevDouble	*attr_TimeSinceReset_read;
	Tango::DevLong	*attr_PipeReadsCount_read;
	Tango::DevLong	*attr_PipeWritesCount_read;
	Tango::DevDouble	*attr_EventSleepPeriod_read;
	Tango::DevLong	*attr_EventsCount_read;
	Tango::DevString	*attr_EventAttribute_read;
	Tango::DevDouble	*attr_BenchmarkSpectrumAttribute_read;
	Tango::DevDouble	*attr_BenchmarkImageAttribute_read;

//	Constructors and destructors
public:
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device Name
	 */
	CppBenchmarkTarget(Tango::DeviceClass *cl,string &s);
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device Name
	 */
	CppBenchmarkTarget(Tango::DeviceClass *cl,const char *s);
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device name
	 *	@param d	Device description.
	 */
	CppBenchmarkTarget(Tango::DeviceClass *cl,const char *s,const char *d);
	/**
	 * The device object destructor.
	 */
	~CppBenchmarkTarget() {delete_device();};


//	Miscellaneous methods
public:
	/*
	 *	will be called at device destruction or at init command.
	 */
	void delete_device();
	/*
	 *	Initialize the device
	 */
	virtual void init_device();
	/*
	 *	Always executed method before execution command method.
	 */
	virtual void always_executed_hook();


//	Attribute methods
public:
	//--------------------------------------------------------
	/*
	 *	Method      : CppBenchmarkTarget::read_attr_hardware()
	 *	Description : Hardware acquisition for attributes.
	 */
	//--------------------------------------------------------
	virtual void read_attr_hardware(vector<long> &attr_list);
	//--------------------------------------------------------
	/*
	 *	Method      : CppBenchmarkTarget::write_attr_hardware()
	 *	Description : Hardware writing for attributes.
	 */
	//--------------------------------------------------------
	virtual void write_attr_hardware(vector<long> &attr_list);

/**
 *	Attribute BenchmarkScalarAttribute related methods
 *	Description: benchmark scalar attribute
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_BenchmarkScalarAttribute(Tango::Attribute &attr);
	virtual void write_BenchmarkScalarAttribute(Tango::WAttribute &attr);
	virtual bool is_BenchmarkScalarAttribute_allowed(Tango::AttReqType type);
/**
 *	Attribute AlwaysExecutedHookCount related methods
 *	Description: always executed hook count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_AlwaysExecutedHookCount(Tango::Attribute &attr);
	virtual bool is_AlwaysExecutedHookCount_allowed(Tango::AttReqType type);
/**
 *	Attribute ReadAttributeHardwareCount related methods
 *	Description: read attribute hardware count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_ReadAttributeHardwareCount(Tango::Attribute &attr);
	virtual bool is_ReadAttributeHardwareCount_allowed(Tango::AttReqType type);
/**
 *	Attribute WriteAttributeCounterCount related methods
 *	Description: write attribute counter count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_WriteAttributeCounterCount(Tango::Attribute &attr);
	virtual bool is_WriteAttributeCounterCount_allowed(Tango::AttReqType type);
/**
 *	Attribute ScalarReadsCount related methods
 *	Description: scalar reads count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_ScalarReadsCount(Tango::Attribute &attr);
	virtual bool is_ScalarReadsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute SpectrumReadsCount related methods
 *	Description: spectrum reads count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_SpectrumReadsCount(Tango::Attribute &attr);
	virtual bool is_SpectrumReadsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute ImageReadsCount related methods
 *	Description: image reads count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_ImageReadsCount(Tango::Attribute &attr);
	virtual bool is_ImageReadsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute ScalarWritesCount related methods
 *	Description: scalar writes count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_ScalarWritesCount(Tango::Attribute &attr);
	virtual bool is_ScalarWritesCount_allowed(Tango::AttReqType type);
/**
 *	Attribute SpectrumWritesCount related methods
 *	Description: spectrum writes count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_SpectrumWritesCount(Tango::Attribute &attr);
	virtual bool is_SpectrumWritesCount_allowed(Tango::AttReqType type);
/**
 *	Attribute ImageWritesCount related methods
 *	Description: image writes count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_ImageWritesCount(Tango::Attribute &attr);
	virtual bool is_ImageWritesCount_allowed(Tango::AttReqType type);
/**
 *	Attribute CommandCallsCount related methods
 *	Description: command calls count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_CommandCallsCount(Tango::Attribute &attr);
	virtual bool is_CommandCallsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute TimeSinceReset related methods
 *	Description: time since reset
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_TimeSinceReset(Tango::Attribute &attr);
	virtual bool is_TimeSinceReset_allowed(Tango::AttReqType type);
/**
 *	Attribute PipeReadsCount related methods
 *	Description: pipe reads count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_PipeReadsCount(Tango::Attribute &attr);
	virtual bool is_PipeReadsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute PipeWritesCount related methods
 *	Description: pipe writes count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_PipeWritesCount(Tango::Attribute &attr);
	virtual bool is_PipeWritesCount_allowed(Tango::AttReqType type);
/**
 *	Attribute EventSleepPeriod related methods
 *	Description: sleep period of the event thread in milliseconds
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_EventSleepPeriod(Tango::Attribute &attr);
	virtual void write_EventSleepPeriod(Tango::WAttribute &attr);
	virtual bool is_EventSleepPeriod_allowed(Tango::AttReqType type);
/**
 *	Attribute EventsCount related methods
 *	Description: events count
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_EventsCount(Tango::Attribute &attr);
	virtual bool is_EventsCount_allowed(Tango::AttReqType type);
/**
 *	Attribute EventAttribute related methods
 *	Description: Attribute passed in events
 *
 *	Data type:	Tango::DevString
 *	Attr type:	Scalar
 */
	virtual void read_EventAttribute(Tango::Attribute &attr);
	virtual void write_EventAttribute(Tango::WAttribute &attr);
	virtual bool is_EventAttribute_allowed(Tango::AttReqType type);
/**
 *	Attribute BenchmarkSpectrumAttribute related methods
 *	Description: benchmark spectrum attribute
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Spectrum max = 4096
 */
	virtual void read_BenchmarkSpectrumAttribute(Tango::Attribute &attr);
	virtual void write_BenchmarkSpectrumAttribute(Tango::WAttribute &attr);
	virtual bool is_BenchmarkSpectrumAttribute_allowed(Tango::AttReqType type);
/**
 *	Attribute BenchmarkImageAttribute related methods
 *	Description: benchmark image attribute
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Image max = 4096 x 4096
 */
	virtual void read_BenchmarkImageAttribute(Tango::Attribute &attr);
	virtual void write_BenchmarkImageAttribute(Tango::WAttribute &attr);
	virtual bool is_BenchmarkImageAttribute_allowed(Tango::AttReqType type);

//	Dynamic attribute methods
public:

	/**
	 *	Attribute BenchmarkDynamicSpectrumAttribute related methods
	 *	Description: dynamic spectrum attribute
	 *
	 *	Data type:	Tango::DevDouble
	 *	Attr type:	Spectrum max = 4096
	 */
	virtual void read_BenchmarkDynamicSpectrumAttribute(Tango::Attribute &attr);
	virtual void write_BenchmarkDynamicSpectrumAttribute(Tango::WAttribute &attr);
	virtual bool is_BenchmarkDynamicSpectrumAttribute_allowed(Tango::AttReqType type);
	void add_BenchmarkDynamicSpectrumAttribute_dynamic_attribute(string attname, Tango::DevDouble *ptr=NULL);
	void remove_BenchmarkDynamicSpectrumAttribute_dynamic_attribute(string attname, bool free_it=true);
	Tango::DevDouble *get_BenchmarkDynamicSpectrumAttribute_data_ptr(string &name);
	map<string,Tango::DevDouble *>	   BenchmarkDynamicSpectrumAttribute_data;

	//--------------------------------------------------------
	/**
	 *	Method      : CppBenchmarkTarget::add_dynamic_attributes()
	 *	Description : Add dynamic attributes if any.
	 */
	//--------------------------------------------------------
	void add_dynamic_attributes();



//	pipe related methods
public:
	//	Pipe BenchmarkPipe
	bool is_BenchmarkPipe_allowed(Tango::PipeReqType);
	void read_BenchmarkPipe(Tango::Pipe &);
	void write_BenchmarkPipe(Tango::WPipe &);

//	Command related methods
public:
	/**
	 *	Command State related method
	 *	Description: This command gets the device state (stored in its device_state data member) and returns it to the caller.
	 *
	 *	@returns Device state
	 */
	virtual Tango::DevState dev_state();
	/**
	 *	Command Status related method
	 *	Description: This command gets the device status (stored in its device_status data member) and returns it to the caller.
	 *
	 *	@returns Device status
	 */
	virtual Tango::ConstDevString dev_status();
	/**
	 *	Command BenchmarkCommand related method
	 *	Description: benchmark command
	 *
	 */
	virtual void benchmark_command();
	virtual bool is_BenchmarkCommand_allowed(const CORBA::Any &any);
	/**
	 *	Command SetSpectrumSize related method
	 *	Description: set spectrum size
	 *
	 *	@param argin spectrum size
	 */
	virtual void set_spectrum_size(Tango::DevLong argin);
	virtual bool is_SetSpectrumSize_allowed(const CORBA::Any &any);
	/**
	 *	Command SetImageSize related method
	 *	Description: set image size
	 *
	 *	@param argin image size
	 */
	virtual void set_image_size(const Tango::DevVarLongArray *argin);
	virtual bool is_SetImageSize_allowed(const CORBA::Any &any);
	/**
	 *	Command ResetCounters related method
	 *	Description: reset counters
	 *
	 */
	virtual void reset_counters();
	virtual bool is_ResetCounters_allowed(const CORBA::Any &any);
	/**
	 *	Command StartEvents related method
	 *	Description: starts a thread which pushes events of BenchmarkScalar Attribute values
	 *
	 */
	virtual void start_events();
	virtual bool is_StartEvents_allowed(const CORBA::Any &any);
	/**
	 *	Command StopEvents related method
	 *	Description: stops a thread which pushes events of BenchmarkScalar Attribute values
	 *
	 */
	virtual void stop_events();
	virtual bool is_StopEvents_allowed(const CORBA::Any &any);
	/**
	 *	Command PushEvent related method
	 *	Description: pushes an event of BenchmarkScalarAttribute
	 *
	 */
	virtual void push_event();
	virtual bool is_PushEvent_allowed(const CORBA::Any &any);
	/**
	 *	Command CreateDynamicAttributes related method
	 *	Description: creates dynamic attributes
	 *
	 *	@param argin attribute configuration
	 */
	virtual void create_dynamic_attributes(const Tango::DevVarLongArray *argin);
	virtual bool is_CreateDynamicAttributes_allowed(const CORBA::Any &any);


	//--------------------------------------------------------
	/**
	 *	Method      : CppBenchmarkTarget::add_dynamic_commands()
	 *	Description : Add dynamic commands if any.
	 */
	//--------------------------------------------------------
	void add_dynamic_commands();

/*----- PROTECTED REGION ID(CppBenchmarkTarget::Additional Method prototypes) ENABLED START -----*/

//	Additional Method prototypes

/*----- PROTECTED REGION END -----*/	//	CppBenchmarkTarget::Additional Method prototypes
};

/*----- PROTECTED REGION ID(CppBenchmarkTarget::Additional Classes Definitions) ENABLED START -----*/

//	Additional Classes Definitions

/*----- PROTECTED REGION END -----*/	//	CppBenchmarkTarget::Additional Classes Definitions

}	//	End of namespace

#endif   //	CppBenchmarkTarget_H
