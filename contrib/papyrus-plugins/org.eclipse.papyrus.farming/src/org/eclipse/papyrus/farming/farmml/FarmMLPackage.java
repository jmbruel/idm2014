/**
 */
package org.eclipse.papyrus.farming.farmml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.farming.farmml.FarmMLFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='FarmML'"
 * @generated
 */
public interface FarmMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "farmml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://Papyrus/FarmML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FarmML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FarmMLPackage eINSTANCE = org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.FarmImpl <em>Farm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFarm()
	 * @generated
	 */
	int FARM = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Farm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Farm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.FieldImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__SIZE = 1;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.SurfaceImpl <em>Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.SurfaceImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getSurface()
	 * @generated
	 */
	int SURFACE = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Irrigated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__IRRIGATED = 1;

	/**
	 * The number of structural features of the '<em>Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.CropSurfaceImpl <em>Crop Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.CropSurfaceImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getCropSurface()
	 * @generated
	 */
	int CROP_SURFACE = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_SURFACE__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Irrigated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_SURFACE__IRRIGATED = SURFACE__IRRIGATED;

	/**
	 * The number of structural features of the '<em>Crop Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_SURFACE_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Crop Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_SURFACE_OPERATION_COUNT = SURFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.FodderSurfaceImpl <em>Fodder Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.FodderSurfaceImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFodderSurface()
	 * @generated
	 */
	int FODDER_SURFACE = 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FODDER_SURFACE__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Irrigated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FODDER_SURFACE__IRRIGATED = SURFACE__IRRIGATED;

	/**
	 * The number of structural features of the '<em>Fodder Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FODDER_SURFACE_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fodder Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FODDER_SURFACE_OPERATION_COUNT = SURFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.ResourceImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.MaterialImpl <em>Material</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.MaterialImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getMaterial()
	 * @generated
	 */
	int MATERIAL = 6;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL__BASE_CLASS = RESOURCE__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Material</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Material</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.HumanImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 7;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = RESOURCE__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.WorkshopImpl <em>Workshop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.WorkshopImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getWorkshop()
	 * @generated
	 */
	int WORKSHOP = 8;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHOP__BASE_ACTIVITY = 0;

	/**
	 * The number of structural features of the '<em>Workshop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHOP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Workshop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHOP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.OvineWSImpl <em>Ovine WS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.OvineWSImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getOvineWS()
	 * @generated
	 */
	int OVINE_WS = 9;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE_WS__BASE_ACTIVITY = WORKSHOP__BASE_ACTIVITY;

	/**
	 * The number of structural features of the '<em>Ovine WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE_WS_FEATURE_COUNT = WORKSHOP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ovine WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE_WS_OPERATION_COUNT = WORKSHOP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.BovineWSImpl <em>Bovine WS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.BovineWSImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getBovineWS()
	 * @generated
	 */
	int BOVINE_WS = 10;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_WS__BASE_ACTIVITY = WORKSHOP__BASE_ACTIVITY;

	/**
	 * The number of structural features of the '<em>Bovine WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_WS_FEATURE_COUNT = WORKSHOP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bovine WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_WS_OPERATION_COUNT = WORKSHOP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.CropWSImpl <em>Crop WS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.CropWSImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getCropWS()
	 * @generated
	 */
	int CROP_WS = 11;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_WS__BASE_ACTIVITY = WORKSHOP__BASE_ACTIVITY;

	/**
	 * The number of structural features of the '<em>Crop WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_WS_FEATURE_COUNT = WORKSHOP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Crop WS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROP_WS_OPERATION_COUNT = WORKSHOP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.ActionImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 12;

	/**
	 * The feature id for the '<em><b>Start Date Min</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__START_DATE_MIN = 0;

	/**
	 * The feature id for the '<em><b>End Date Max</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__END_DATE_MAX = 1;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__FREQUENCY = 2;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DURATION = 3;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__BASE_ACTION = 4;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.impl.DateImpl
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 13;

	/**
	 * The feature id for the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__DAY = 0;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__MONTH = 1;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.Month <em>Month</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.Month
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getMonth()
	 * @generated
	 */
	int MONTH = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.farming.farmml.Frequency <em>Frequency</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.farming.farmml.Frequency
	 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFrequency()
	 * @generated
	 */
	int FREQUENCY = 15;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Farm <em>Farm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Farm</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Farm
	 * @generated
	 */
	EClass getFarm();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Farm#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Farm#getBase_Class()
	 * @see #getFarm()
	 * @generated
	 */
	EReference getFarm_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Field#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Field#getBase_Class()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Field#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Field#getSize()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Surface <em>Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Surface</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Surface
	 * @generated
	 */
	EClass getSurface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Surface#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Surface#getBase_Class()
	 * @see #getSurface()
	 * @generated
	 */
	EReference getSurface_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Surface#isIrrigated <em>Irrigated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Irrigated</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Surface#isIrrigated()
	 * @see #getSurface()
	 * @generated
	 */
	EAttribute getSurface_Irrigated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.CropSurface <em>Crop Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crop Surface</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.CropSurface
	 * @generated
	 */
	EClass getCropSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.FodderSurface <em>Fodder Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fodder Surface</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.FodderSurface
	 * @generated
	 */
	EClass getFodderSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Resource#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Resource#getBase_Property()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Resource#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Resource#getBase_Class()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Material <em>Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Material</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Material
	 * @generated
	 */
	EClass getMaterial();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Workshop <em>Workshop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workshop</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Workshop
	 * @generated
	 */
	EClass getWorkshop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Workshop#getBase_Activity <em>Base Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Workshop#getBase_Activity()
	 * @see #getWorkshop()
	 * @generated
	 */
	EReference getWorkshop_Base_Activity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.OvineWS <em>Ovine WS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ovine WS</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.OvineWS
	 * @generated
	 */
	EClass getOvineWS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.BovineWS <em>Bovine WS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bovine WS</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.BovineWS
	 * @generated
	 */
	EClass getBovineWS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.CropWS <em>Crop WS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crop WS</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.CropWS
	 * @generated
	 */
	EClass getCropWS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.farming.farmml.Action#getStartDateMin <em>Start Date Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Date Min</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action#getStartDateMin()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_StartDateMin();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.farming.farmml.Action#getEndDateMax <em>End Date Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Date Max</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action#getEndDateMax()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_EndDateMax();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Action#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action#getFrequency()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Frequency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Action#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action#getDuration()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Duration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.farming.farmml.Action#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Action#getBase_Action()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Base_Action();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.farming.farmml.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Date#getDay <em>Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Day</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Date#getDay()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Day();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.farming.farmml.Date#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Date#getMonth()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Month();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.farming.farmml.Month <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Month</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Month
	 * @generated
	 */
	EEnum getMonth();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.farming.farmml.Frequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Frequency</em>'.
	 * @see org.eclipse.papyrus.farming.farmml.Frequency
	 * @generated
	 */
	EEnum getFrequency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FarmMLFactory getFarmMLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.FarmImpl <em>Farm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFarm()
		 * @generated
		 */
		EClass FARM = eINSTANCE.getFarm();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARM__BASE_CLASS = eINSTANCE.getFarm_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.FieldImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__BASE_CLASS = eINSTANCE.getField_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__SIZE = eINSTANCE.getField_Size();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.SurfaceImpl <em>Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.SurfaceImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getSurface()
		 * @generated
		 */
		EClass SURFACE = eINSTANCE.getSurface();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURFACE__BASE_CLASS = eINSTANCE.getSurface_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Irrigated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SURFACE__IRRIGATED = eINSTANCE.getSurface_Irrigated();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.CropSurfaceImpl <em>Crop Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.CropSurfaceImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getCropSurface()
		 * @generated
		 */
		EClass CROP_SURFACE = eINSTANCE.getCropSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.FodderSurfaceImpl <em>Fodder Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.FodderSurfaceImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFodderSurface()
		 * @generated
		 */
		EClass FODDER_SURFACE = eINSTANCE.getFodderSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.ResourceImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_PROPERTY = eINSTANCE.getResource_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_CLASS = eINSTANCE.getResource_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.MaterialImpl <em>Material</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.MaterialImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getMaterial()
		 * @generated
		 */
		EClass MATERIAL = eINSTANCE.getMaterial();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.HumanImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.WorkshopImpl <em>Workshop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.WorkshopImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getWorkshop()
		 * @generated
		 */
		EClass WORKSHOP = eINSTANCE.getWorkshop();

		/**
		 * The meta object literal for the '<em><b>Base Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSHOP__BASE_ACTIVITY = eINSTANCE.getWorkshop_Base_Activity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.OvineWSImpl <em>Ovine WS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.OvineWSImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getOvineWS()
		 * @generated
		 */
		EClass OVINE_WS = eINSTANCE.getOvineWS();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.BovineWSImpl <em>Bovine WS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.BovineWSImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getBovineWS()
		 * @generated
		 */
		EClass BOVINE_WS = eINSTANCE.getBovineWS();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.CropWSImpl <em>Crop WS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.CropWSImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getCropWS()
		 * @generated
		 */
		EClass CROP_WS = eINSTANCE.getCropWS();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.ActionImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Start Date Min</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__START_DATE_MIN = eINSTANCE.getAction_StartDateMin();

		/**
		 * The meta object literal for the '<em><b>End Date Max</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__END_DATE_MAX = eINSTANCE.getAction_EndDateMax();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__FREQUENCY = eINSTANCE.getAction_Frequency();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DURATION = eINSTANCE.getAction_Duration();

		/**
		 * The meta object literal for the '<em><b>Base Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__BASE_ACTION = eINSTANCE.getAction_Base_Action();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.impl.DateImpl
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__DAY = eINSTANCE.getDate_Day();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__MONTH = eINSTANCE.getDate_Month();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.Month <em>Month</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.Month
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getMonth()
		 * @generated
		 */
		EEnum MONTH = eINSTANCE.getMonth();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.farming.farmml.Frequency <em>Frequency</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.farming.farmml.Frequency
		 * @see org.eclipse.papyrus.farming.farmml.impl.FarmMLPackageImpl#getFrequency()
		 * @generated
		 */
		EEnum FREQUENCY = eINSTANCE.getFrequency();

	}

} //FarmMLPackage
