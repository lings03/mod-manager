# automatically generated by the FlatBuffers compiler, do not modify

# namespace: 

import flatbuffers
from flatbuffers.compat import import_numpy
np = import_numpy()

class enum__Torappu_CharmRarity(object):
    NONE = 0
    LOW = 1
    MEDIUM = 2
    HIGH = 3


class enum__Torappu_ProfessionCategory(object):
    NONE = 0
    WARRIOR = 1
    SNIPER = 2
    TANK = 4
    MEDIC = 8
    SUPPORT = 16
    CASTER = 32
    SPECIAL = 64
    TOKEN = 128
    TRAP = 256
    PIONEER = 512


class enum__Torappu_BuildableType(object):
    NONE = 0
    MELEE = 1
    RANGED = 2
    ALL = 3


class enum__Torappu_PlayerSideMask(object):
    ALL = 0
    SIDE_A = 1
    SIDE_B = 2
    NONE = 3


class clz_Torappu_RuneData_Selector(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_RuneData_Selector()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_RuneData_Selector(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_RuneData_Selector
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_RuneData_Selector
    def ProfessionMask(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_RuneData_Selector
    def BuildableMask(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_RuneData_Selector
    def PlayerSideMask(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Uint8Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_RuneData_Selector
    def CharIdFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def CharIdFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def CharIdFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def EnemyIdFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def EnemyIdFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def EnemyIdFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def EnemyIdExcludeFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def EnemyIdExcludeFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def EnemyIdExcludeFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def EnemyLevelTypeFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def EnemyLevelTypeFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def EnemyLevelTypeFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def SkillIdFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def SkillIdFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def SkillIdFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def TileKeyFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def TileKeyFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def TileKeyFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def GroupTagFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(22))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def GroupTagFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(22))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def GroupTagFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(22))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def FilterTagFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def FilterTagFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def FilterTagFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def FilterTagExcludeFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(26))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def FilterTagExcludeFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(26))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def FilterTagExcludeFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(26))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def SubProfessionExcludeFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(28))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def SubProfessionExcludeFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(28))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def SubProfessionExcludeFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(28))
        return o == 0

    # clz_Torappu_RuneData_Selector
    def MapTagFilter(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_RuneData_Selector
    def MapTagFilterLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData_Selector
    def MapTagFilterIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        return o == 0

def clz_Torappu_RuneData_SelectorStart(builder):
    builder.StartObject(14)

def clz_Torappu_RuneData_SelectorAddProfessionMask(builder, professionMask):
    builder.PrependInt32Slot(0, professionMask, 0)

def clz_Torappu_RuneData_SelectorAddBuildableMask(builder, buildableMask):
    builder.PrependInt32Slot(1, buildableMask, 0)

def clz_Torappu_RuneData_SelectorAddPlayerSideMask(builder, playerSideMask):
    builder.PrependUint8Slot(2, playerSideMask, 0)

def clz_Torappu_RuneData_SelectorAddCharIdFilter(builder, charIdFilter):
    builder.PrependUOffsetTRelativeSlot(3, flatbuffers.number_types.UOffsetTFlags.py_type(charIdFilter), 0)

def clz_Torappu_RuneData_SelectorStartCharIdFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddEnemyIdFilter(builder, enemyIdFilter):
    builder.PrependUOffsetTRelativeSlot(4, flatbuffers.number_types.UOffsetTFlags.py_type(enemyIdFilter), 0)

def clz_Torappu_RuneData_SelectorStartEnemyIdFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddEnemyIdExcludeFilter(builder, enemyIdExcludeFilter):
    builder.PrependUOffsetTRelativeSlot(5, flatbuffers.number_types.UOffsetTFlags.py_type(enemyIdExcludeFilter), 0)

def clz_Torappu_RuneData_SelectorStartEnemyIdExcludeFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddEnemyLevelTypeFilter(builder, enemyLevelTypeFilter):
    builder.PrependUOffsetTRelativeSlot(6, flatbuffers.number_types.UOffsetTFlags.py_type(enemyLevelTypeFilter), 0)

def clz_Torappu_RuneData_SelectorStartEnemyLevelTypeFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddSkillIdFilter(builder, skillIdFilter):
    builder.PrependUOffsetTRelativeSlot(7, flatbuffers.number_types.UOffsetTFlags.py_type(skillIdFilter), 0)

def clz_Torappu_RuneData_SelectorStartSkillIdFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddTileKeyFilter(builder, tileKeyFilter):
    builder.PrependUOffsetTRelativeSlot(8, flatbuffers.number_types.UOffsetTFlags.py_type(tileKeyFilter), 0)

def clz_Torappu_RuneData_SelectorStartTileKeyFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddGroupTagFilter(builder, groupTagFilter):
    builder.PrependUOffsetTRelativeSlot(9, flatbuffers.number_types.UOffsetTFlags.py_type(groupTagFilter), 0)

def clz_Torappu_RuneData_SelectorStartGroupTagFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddFilterTagFilter(builder, filterTagFilter):
    builder.PrependUOffsetTRelativeSlot(10, flatbuffers.number_types.UOffsetTFlags.py_type(filterTagFilter), 0)

def clz_Torappu_RuneData_SelectorStartFilterTagFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddFilterTagExcludeFilter(builder, filterTagExcludeFilter):
    builder.PrependUOffsetTRelativeSlot(11, flatbuffers.number_types.UOffsetTFlags.py_type(filterTagExcludeFilter), 0)

def clz_Torappu_RuneData_SelectorStartFilterTagExcludeFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddSubProfessionExcludeFilter(builder, subProfessionExcludeFilter):
    builder.PrependUOffsetTRelativeSlot(12, flatbuffers.number_types.UOffsetTFlags.py_type(subProfessionExcludeFilter), 0)

def clz_Torappu_RuneData_SelectorStartSubProfessionExcludeFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorAddMapTagFilter(builder, mapTagFilter):
    builder.PrependUOffsetTRelativeSlot(13, flatbuffers.number_types.UOffsetTFlags.py_type(mapTagFilter), 0)

def clz_Torappu_RuneData_SelectorStartMapTagFilterVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneData_SelectorEnd(builder):
    return builder.EndObject()



class clz_Torappu_Blackboard_DataPair(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_Blackboard_DataPair()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_Blackboard_DataPair(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_Blackboard_DataPair
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_Blackboard_DataPair
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_Blackboard_DataPair
    def Value(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Float32Flags, o + self._tab.Pos)
        return 0.0

    # clz_Torappu_Blackboard_DataPair
    def ValueStr(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

def clz_Torappu_Blackboard_DataPairStart(builder):
    builder.StartObject(3)

def clz_Torappu_Blackboard_DataPairAddKey(builder, key):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(key), 0)

def clz_Torappu_Blackboard_DataPairAddValue(builder, value):
    builder.PrependFloat32Slot(1, value, 0.0)

def clz_Torappu_Blackboard_DataPairAddValueStr(builder, valueStr):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(valueStr), 0)

def clz_Torappu_Blackboard_DataPairEnd(builder):
    return builder.EndObject()



class clz_Torappu_RuneData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_RuneData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_RuneData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_RuneData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_RuneData
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_RuneData
    def Selector(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_RuneData_Selector()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_RuneData
    def Blackboard(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = clz_Torappu_Blackboard_DataPair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_RuneData
    def BlackboardLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneData
    def BlackboardIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        return o == 0

def clz_Torappu_RuneDataStart(builder):
    builder.StartObject(3)

def clz_Torappu_RuneDataAddKey(builder, key):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(key), 0)

def clz_Torappu_RuneDataAddSelector(builder, selector):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(selector), 0)

def clz_Torappu_RuneDataAddBlackboard(builder, blackboard):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(blackboard), 0)

def clz_Torappu_RuneDataStartBlackboardVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneDataEnd(builder):
    return builder.EndObject()



class clz_Torappu_RuneTable_PackedRuneData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_RuneTable_PackedRuneData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_RuneTable_PackedRuneData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_RuneTable_PackedRuneData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_RuneTable_PackedRuneData
    def Id(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_RuneTable_PackedRuneData
    def Points(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Float32Flags, o + self._tab.Pos)
        return 0.0

    # clz_Torappu_RuneTable_PackedRuneData
    def MutexGroupKey(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_RuneTable_PackedRuneData
    def Description(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_RuneTable_PackedRuneData
    def Runes(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = clz_Torappu_RuneData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_RuneTable_PackedRuneData
    def RunesLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_RuneTable_PackedRuneData
    def RunesIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        return o == 0

def clz_Torappu_RuneTable_PackedRuneDataStart(builder):
    builder.StartObject(5)

def clz_Torappu_RuneTable_PackedRuneDataAddId(builder, id):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(id), 0)

def clz_Torappu_RuneTable_PackedRuneDataAddPoints(builder, points):
    builder.PrependFloat32Slot(1, points, 0.0)

def clz_Torappu_RuneTable_PackedRuneDataAddMutexGroupKey(builder, mutexGroupKey):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(mutexGroupKey), 0)

def clz_Torappu_RuneTable_PackedRuneDataAddDescription(builder, description):
    builder.PrependUOffsetTRelativeSlot(3, flatbuffers.number_types.UOffsetTFlags.py_type(description), 0)

def clz_Torappu_RuneTable_PackedRuneDataAddRunes(builder, runes):
    builder.PrependUOffsetTRelativeSlot(4, flatbuffers.number_types.UOffsetTFlags.py_type(runes), 0)

def clz_Torappu_RuneTable_PackedRuneDataStartRunesVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_RuneTable_PackedRuneDataEnd(builder):
    return builder.EndObject()



class clz_Torappu_CharmItemData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_CharmItemData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_CharmItemData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_CharmItemData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_CharmItemData
    def Id(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def Sort(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_CharmItemData
    def Name(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def Icon(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def ItemUsage(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def ItemDesc(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def ItemObtainApproach(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def Rarity(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_CharmItemData
    def Desc(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def Price(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(22))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_CharmItemData
    def SpecialObtainApproach(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def CharmType(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(26))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_CharmItemData
    def ObtainInRandom(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(28))
        if o != 0:
            return bool(self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos))
        return False

    # clz_Torappu_CharmItemData
    def DropStages(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_CharmItemData
    def DropStagesLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_CharmItemData
    def DropStagesIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        return o == 0

    # clz_Torappu_CharmItemData
    def RuneData(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(32))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_RuneTable_PackedRuneData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

def clz_Torappu_CharmItemDataStart(builder):
    builder.StartObject(15)

def clz_Torappu_CharmItemDataAddId(builder, id):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(id), 0)

def clz_Torappu_CharmItemDataAddSort(builder, sort):
    builder.PrependInt32Slot(1, sort, 0)

def clz_Torappu_CharmItemDataAddName(builder, name):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(name), 0)

def clz_Torappu_CharmItemDataAddIcon(builder, icon):
    builder.PrependUOffsetTRelativeSlot(3, flatbuffers.number_types.UOffsetTFlags.py_type(icon), 0)

def clz_Torappu_CharmItemDataAddItemUsage(builder, itemUsage):
    builder.PrependUOffsetTRelativeSlot(4, flatbuffers.number_types.UOffsetTFlags.py_type(itemUsage), 0)

def clz_Torappu_CharmItemDataAddItemDesc(builder, itemDesc):
    builder.PrependUOffsetTRelativeSlot(5, flatbuffers.number_types.UOffsetTFlags.py_type(itemDesc), 0)

def clz_Torappu_CharmItemDataAddItemObtainApproach(builder, itemObtainApproach):
    builder.PrependUOffsetTRelativeSlot(6, flatbuffers.number_types.UOffsetTFlags.py_type(itemObtainApproach), 0)

def clz_Torappu_CharmItemDataAddRarity(builder, rarity):
    builder.PrependInt32Slot(7, rarity, 0)

def clz_Torappu_CharmItemDataAddDesc(builder, desc):
    builder.PrependUOffsetTRelativeSlot(8, flatbuffers.number_types.UOffsetTFlags.py_type(desc), 0)

def clz_Torappu_CharmItemDataAddPrice(builder, price):
    builder.PrependInt32Slot(9, price, 0)

def clz_Torappu_CharmItemDataAddSpecialObtainApproach(builder, specialObtainApproach):
    builder.PrependUOffsetTRelativeSlot(10, flatbuffers.number_types.UOffsetTFlags.py_type(specialObtainApproach), 0)

def clz_Torappu_CharmItemDataAddCharmType(builder, charmType):
    builder.PrependUOffsetTRelativeSlot(11, flatbuffers.number_types.UOffsetTFlags.py_type(charmType), 0)

def clz_Torappu_CharmItemDataAddObtainInRandom(builder, obtainInRandom):
    builder.PrependBoolSlot(12, obtainInRandom, 0)

def clz_Torappu_CharmItemDataAddDropStages(builder, dropStages):
    builder.PrependUOffsetTRelativeSlot(13, flatbuffers.number_types.UOffsetTFlags.py_type(dropStages), 0)

def clz_Torappu_CharmItemDataStartDropStagesVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_CharmItemDataAddRuneData(builder, runeData):
    builder.PrependUOffsetTRelativeSlot(14, flatbuffers.number_types.UOffsetTFlags.py_type(runeData), 0)

def clz_Torappu_CharmItemDataEnd(builder):
    return builder.EndObject()



class clz_Torappu_CharmData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_CharmData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_CharmData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_CharmData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_CharmData
    def CharmList(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = clz_Torappu_CharmItemData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_CharmData
    def CharmListLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_CharmData
    def CharmListIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        return o == 0

def clz_Torappu_CharmDataStart(builder):
    builder.StartObject(1)

def clz_Torappu_CharmDataAddCharmList(builder, charmList):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(charmList), 0)

def clz_Torappu_CharmDataStartCharmListVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_CharmDataEnd(builder):
    return builder.EndObject()

ROOT_TYPE = clz_Torappu_CharmData
