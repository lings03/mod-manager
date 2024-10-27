# automatically generated by the FlatBuffers compiler, do not modify

# namespace: 

import flatbuffers
from flatbuffers.compat import import_numpy
np = import_numpy()

class enum__Torappu_EnemyLevelType(object):
    NORMAL = 0
    ELITE = 1
    BOSS = 2
    E_NUM = 3


class enum__Torappu_EnemyHandBookData_TextFormat(object):
    NORMAL = 0
    TITLE = 1
    SILENCE = 2


class enum__Torappu_EnemyHandBookDamageType(object):
    PHYSIC = 0
    MAGIC = 1
    HEAL = 2
    NO_DAMAGE = 3


class clz_Torappu_EnemyHandbookLevelInfoData_RangePair(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandbookLevelInfoData_RangePair(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandbookLevelInfoData_RangePair
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandbookLevelInfoData_RangePair
    def Min(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Float32Flags, o + self._tab.Pos)
        return 0.0

    # clz_Torappu_EnemyHandbookLevelInfoData_RangePair
    def Max(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Float32Flags, o + self._tab.Pos)
        return 0.0

def clz_Torappu_EnemyHandbookLevelInfoData_RangePairStart(builder):
    builder.StartObject(2)

def clz_Torappu_EnemyHandbookLevelInfoData_RangePairAddMin(builder, min):
    builder.PrependFloat32Slot(0, min, 0.0)

def clz_Torappu_EnemyHandbookLevelInfoData_RangePairAddMax(builder, max):
    builder.PrependFloat32Slot(1, max, 0.0)

def clz_Torappu_EnemyHandbookLevelInfoData_RangePairEnd(builder):
    return builder.EndObject()



class clz_Torappu_EnemyHandbookLevelInfoData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandbookLevelInfoData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandbookLevelInfoData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandbookLevelInfoData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandbookLevelInfoData
    def ClassLevel(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def Attack(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def Def_(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def MagicRes(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def MaxHp(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def MoveSpeed(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def AttackSpeed(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def EnemyDamageRes(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandbookLevelInfoData
    def EnemyRes(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookLevelInfoData_RangePair()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

def clz_Torappu_EnemyHandbookLevelInfoDataStart(builder):
    builder.StartObject(9)

def clz_Torappu_EnemyHandbookLevelInfoDataAddClassLevel(builder, classLevel):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(classLevel), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddAttack(builder, attack):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(attack), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddDef_(builder, def_):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(def_), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddMagicRes(builder, magicRes):
    builder.PrependUOffsetTRelativeSlot(3, flatbuffers.number_types.UOffsetTFlags.py_type(magicRes), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddMaxHp(builder, maxHp):
    builder.PrependUOffsetTRelativeSlot(4, flatbuffers.number_types.UOffsetTFlags.py_type(maxHp), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddMoveSpeed(builder, moveSpeed):
    builder.PrependUOffsetTRelativeSlot(5, flatbuffers.number_types.UOffsetTFlags.py_type(moveSpeed), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddAttackSpeed(builder, attackSpeed):
    builder.PrependUOffsetTRelativeSlot(6, flatbuffers.number_types.UOffsetTFlags.py_type(attackSpeed), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddEnemyDamageRes(builder, enemyDamageRes):
    builder.PrependUOffsetTRelativeSlot(7, flatbuffers.number_types.UOffsetTFlags.py_type(enemyDamageRes), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataAddEnemyRes(builder, enemyRes):
    builder.PrependUOffsetTRelativeSlot(8, flatbuffers.number_types.UOffsetTFlags.py_type(enemyRes), 0)

def clz_Torappu_EnemyHandbookLevelInfoDataEnd(builder):
    return builder.EndObject()



class dict__string__int(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = dict__string__int()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsdict__string__int(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # dict__string__int
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # dict__string__int
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # dict__string__int
    def Value(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

def dict__string__intStart(builder):
    builder.StartObject(2)

def dict__string__intAddKey(builder, key):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(key), 0)

def dict__string__intAddValue(builder, value):
    builder.PrependInt32Slot(1, value, 0)

def dict__string__intEnd(builder):
    return builder.EndObject()



class clz_Torappu_EnemyHandBookData_Abilty(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandBookData_Abilty()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandBookData_Abilty(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandBookData_Abilty
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandBookData_Abilty
    def Text(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData_Abilty
    def TextFormat(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

def clz_Torappu_EnemyHandBookData_AbiltyStart(builder):
    builder.StartObject(2)

def clz_Torappu_EnemyHandBookData_AbiltyAddText(builder, text):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(text), 0)

def clz_Torappu_EnemyHandBookData_AbiltyAddTextFormat(builder, textFormat):
    builder.PrependInt32Slot(1, textFormat, 0)

def clz_Torappu_EnemyHandBookData_AbiltyEnd(builder):
    return builder.EndObject()



class clz_Torappu_EnemyHandBookData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandBookData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandBookData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandBookData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandBookData
    def EnemyId(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def EnemyIndex(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def EnemyTags(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_EnemyHandBookData
    def EnemyTagsLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def EnemyTagsIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        return o == 0

    # clz_Torappu_EnemyHandBookData
    def SortId(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(10))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_EnemyHandBookData
    def Name(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(12))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def EnemyLevel(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(14))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

    # clz_Torappu_EnemyHandBookData
    def Description(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(16))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def AttackType(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(18))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def Ability(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(20))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandBookData
    def IsInvalidKilled(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(22))
        if o != 0:
            return bool(self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos))
        return False

    # clz_Torappu_EnemyHandBookData
    def OverrideKillCntInfos(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = dict__string__int()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandBookData
    def OverrideKillCntInfosLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def OverrideKillCntInfosIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(24))
        return o == 0

    # clz_Torappu_EnemyHandBookData
    def HideInHandbook(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(26))
        if o != 0:
            return bool(self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos))
        return False

    # clz_Torappu_EnemyHandBookData
    def HideInStage(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(28))
        if o != 0:
            return bool(self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos))
        return False

    # clz_Torappu_EnemyHandBookData
    def AbilityList(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = clz_Torappu_EnemyHandBookData_Abilty()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandBookData
    def AbilityListLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def AbilityListIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(30))
        return o == 0

    # clz_Torappu_EnemyHandBookData
    def LinkEnemies(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(32))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.String(a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return ""

    # clz_Torappu_EnemyHandBookData
    def LinkEnemiesLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(32))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def LinkEnemiesIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(32))
        return o == 0

    # clz_Torappu_EnemyHandBookData
    def DamageType(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(34))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.Get(flatbuffers.number_types.Int32Flags, a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 4))
        return 0

    # clz_Torappu_EnemyHandBookData
    def DamageTypeAsNumpy(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(34))
        if o != 0:
            return self._tab.GetVectorAsNumpy(flatbuffers.number_types.Int32Flags, o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def DamageTypeLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(34))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookData
    def DamageTypeIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(34))
        return o == 0

    # clz_Torappu_EnemyHandBookData
    def InvisibleDetail(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(36))
        if o != 0:
            return bool(self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos))
        return False

def clz_Torappu_EnemyHandBookDataStart(builder):
    builder.StartObject(17)

def clz_Torappu_EnemyHandBookDataAddEnemyId(builder, enemyId):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(enemyId), 0)

def clz_Torappu_EnemyHandBookDataAddEnemyIndex(builder, enemyIndex):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(enemyIndex), 0)

def clz_Torappu_EnemyHandBookDataAddEnemyTags(builder, enemyTags):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(enemyTags), 0)

def clz_Torappu_EnemyHandBookDataStartEnemyTagsVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataAddSortId(builder, sortId):
    builder.PrependInt32Slot(3, sortId, 0)

def clz_Torappu_EnemyHandBookDataAddName(builder, name):
    builder.PrependUOffsetTRelativeSlot(4, flatbuffers.number_types.UOffsetTFlags.py_type(name), 0)

def clz_Torappu_EnemyHandBookDataAddEnemyLevel(builder, enemyLevel):
    builder.PrependInt32Slot(5, enemyLevel, 0)

def clz_Torappu_EnemyHandBookDataAddDescription(builder, description):
    builder.PrependUOffsetTRelativeSlot(6, flatbuffers.number_types.UOffsetTFlags.py_type(description), 0)

def clz_Torappu_EnemyHandBookDataAddAttackType(builder, attackType):
    builder.PrependUOffsetTRelativeSlot(7, flatbuffers.number_types.UOffsetTFlags.py_type(attackType), 0)

def clz_Torappu_EnemyHandBookDataAddAbility(builder, ability):
    builder.PrependUOffsetTRelativeSlot(8, flatbuffers.number_types.UOffsetTFlags.py_type(ability), 0)

def clz_Torappu_EnemyHandBookDataAddIsInvalidKilled(builder, isInvalidKilled):
    builder.PrependBoolSlot(9, isInvalidKilled, 0)

def clz_Torappu_EnemyHandBookDataAddOverrideKillCntInfos(builder, overrideKillCntInfos):
    builder.PrependUOffsetTRelativeSlot(10, flatbuffers.number_types.UOffsetTFlags.py_type(overrideKillCntInfos), 0)

def clz_Torappu_EnemyHandBookDataStartOverrideKillCntInfosVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataAddHideInHandbook(builder, hideInHandbook):
    builder.PrependBoolSlot(11, hideInHandbook, 0)

def clz_Torappu_EnemyHandBookDataAddHideInStage(builder, hideInStage):
    builder.PrependBoolSlot(12, hideInStage, 0)

def clz_Torappu_EnemyHandBookDataAddAbilityList(builder, abilityList):
    builder.PrependUOffsetTRelativeSlot(13, flatbuffers.number_types.UOffsetTFlags.py_type(abilityList), 0)

def clz_Torappu_EnemyHandBookDataStartAbilityListVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataAddLinkEnemies(builder, linkEnemies):
    builder.PrependUOffsetTRelativeSlot(14, flatbuffers.number_types.UOffsetTFlags.py_type(linkEnemies), 0)

def clz_Torappu_EnemyHandBookDataStartLinkEnemiesVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataAddDamageType(builder, damageType):
    builder.PrependUOffsetTRelativeSlot(15, flatbuffers.number_types.UOffsetTFlags.py_type(damageType), 0)

def clz_Torappu_EnemyHandBookDataStartDamageTypeVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataAddInvisibleDetail(builder, invisibleDetail):
    builder.PrependBoolSlot(16, invisibleDetail, 0)

def clz_Torappu_EnemyHandBookDataEnd(builder):
    return builder.EndObject()



class dict__string__clz_Torappu_EnemyHandBookData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = dict__string__clz_Torappu_EnemyHandBookData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsdict__string__clz_Torappu_EnemyHandBookData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # dict__string__clz_Torappu_EnemyHandBookData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # dict__string__clz_Torappu_EnemyHandBookData
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # dict__string__clz_Torappu_EnemyHandBookData
    def Value(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandBookData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

def dict__string__clz_Torappu_EnemyHandBookDataStart(builder):
    builder.StartObject(2)

def dict__string__clz_Torappu_EnemyHandBookDataAddKey(builder, key):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(key), 0)

def dict__string__clz_Torappu_EnemyHandBookDataAddValue(builder, value):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(value), 0)

def dict__string__clz_Torappu_EnemyHandBookDataEnd(builder):
    return builder.EndObject()



class clz_Torappu_EnemyHandbookRaceData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandbookRaceData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandbookRaceData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandbookRaceData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandbookRaceData
    def Id(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandbookRaceData
    def RaceName(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # clz_Torappu_EnemyHandbookRaceData
    def SortId(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int32Flags, o + self._tab.Pos)
        return 0

def clz_Torappu_EnemyHandbookRaceDataStart(builder):
    builder.StartObject(3)

def clz_Torappu_EnemyHandbookRaceDataAddId(builder, id):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(id), 0)

def clz_Torappu_EnemyHandbookRaceDataAddRaceName(builder, raceName):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(raceName), 0)

def clz_Torappu_EnemyHandbookRaceDataAddSortId(builder, sortId):
    builder.PrependInt32Slot(2, sortId, 0)

def clz_Torappu_EnemyHandbookRaceDataEnd(builder):
    return builder.EndObject()



class dict__string__clz_Torappu_EnemyHandbookRaceData(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = dict__string__clz_Torappu_EnemyHandbookRaceData()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsdict__string__clz_Torappu_EnemyHandbookRaceData(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # dict__string__clz_Torappu_EnemyHandbookRaceData
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # dict__string__clz_Torappu_EnemyHandbookRaceData
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.String(o + self._tab.Pos)
        return None

    # dict__string__clz_Torappu_EnemyHandbookRaceData
    def Value(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            x = self._tab.Indirect(o + self._tab.Pos)
            obj = clz_Torappu_EnemyHandbookRaceData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

def dict__string__clz_Torappu_EnemyHandbookRaceDataStart(builder):
    builder.StartObject(2)

def dict__string__clz_Torappu_EnemyHandbookRaceDataAddKey(builder, key):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(key), 0)

def dict__string__clz_Torappu_EnemyHandbookRaceDataAddValue(builder, value):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(value), 0)

def dict__string__clz_Torappu_EnemyHandbookRaceDataEnd(builder):
    return builder.EndObject()



class clz_Torappu_EnemyHandBookDataGroup(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAs(cls, buf, offset=0):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = clz_Torappu_EnemyHandBookDataGroup()
        x.Init(buf, n + offset)
        return x

    @classmethod
    def GetRootAsclz_Torappu_EnemyHandBookDataGroup(cls, buf, offset=0):
        """This method is deprecated. Please switch to GetRootAs."""
        return cls.GetRootAs(buf, offset)
    # clz_Torappu_EnemyHandBookDataGroup
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # clz_Torappu_EnemyHandBookDataGroup
    def LevelInfoList(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = clz_Torappu_EnemyHandbookLevelInfoData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandBookDataGroup
    def LevelInfoListLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookDataGroup
    def LevelInfoListIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        return o == 0

    # clz_Torappu_EnemyHandBookDataGroup
    def EnemyData(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = dict__string__clz_Torappu_EnemyHandBookData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandBookDataGroup
    def EnemyDataLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookDataGroup
    def EnemyDataIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        return o == 0

    # clz_Torappu_EnemyHandBookDataGroup
    def RaceData(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            x = self._tab.Vector(o)
            x += flatbuffers.number_types.UOffsetTFlags.py_type(j) * 4
            x = self._tab.Indirect(x)
            obj = dict__string__clz_Torappu_EnemyHandbookRaceData()
            obj.Init(self._tab.Bytes, x)
            return obj
        return None

    # clz_Torappu_EnemyHandBookDataGroup
    def RaceDataLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # clz_Torappu_EnemyHandBookDataGroup
    def RaceDataIsNone(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        return o == 0

def clz_Torappu_EnemyHandBookDataGroupStart(builder):
    builder.StartObject(3)

def clz_Torappu_EnemyHandBookDataGroupAddLevelInfoList(builder, levelInfoList):
    builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(levelInfoList), 0)

def clz_Torappu_EnemyHandBookDataGroupStartLevelInfoListVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataGroupAddEnemyData(builder, enemyData):
    builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(enemyData), 0)

def clz_Torappu_EnemyHandBookDataGroupStartEnemyDataVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataGroupAddRaceData(builder, raceData):
    builder.PrependUOffsetTRelativeSlot(2, flatbuffers.number_types.UOffsetTFlags.py_type(raceData), 0)

def clz_Torappu_EnemyHandBookDataGroupStartRaceDataVector(builder, numElems):
    return builder.StartVector(4, numElems, 4)

def clz_Torappu_EnemyHandBookDataGroupEnd(builder):
    return builder.EndObject()

ROOT_TYPE = clz_Torappu_EnemyHandBookDataGroup
